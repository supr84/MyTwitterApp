/*
 * Copyright 2011 Pradhan Sushanta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * @author Sushanta Pradhan - sushanta.pradhan@gmail.com
 * @since MyTwitterApp 1.0.0
 */

package org.sush.twitterstream;

import static org.sush.constants.Configuration.JAVA_CONFIG;
import static org.sush.constants.Configuration.USER_ACCESS_DIR;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.Set;

import twitter4j.ConnectionLifeCycleListener;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
public class MyTwitterStream {
	
private TwitterStream twitterStream;

private StatusListener statusListener;

private ConnectionLifeCycleListener connectionListener;

private TwitterException twitterException;

private boolean isStreamOn;

private Set<String> predicates;

private ConfigurationBuilder configurationBuilder;
public Set<String> getPredicates() {
	return predicates;
}

public void setPredicates(Set<String> predicates) {
	this.predicates = predicates;
}

public TwitterException getTwitterException() {
	return twitterException;
}

public void setTwitterException(TwitterException twitterException) {
	this.twitterException = twitterException;
}

public boolean isStreamOn() {
	return isStreamOn;
}

public void setStreamOn(boolean isStreamOn) {
	this.isStreamOn = isStreamOn;
}

public void init() throws IOException{
	configurationBuilder = new ConfigurationBuilder();
	String configDIr = System.getenv("SUSH_JAVA_CONFIG");
	File file = new File("E:\\java_config\\twitter4j.properties");
	Properties properties = new Properties();
	if(file.exists()){
		InputStream fileInputStream = new FileInputStream(file);
		properties.load(fileInputStream);
	}
	else{
		System.out.println("Property file not found... Program Exiting");
		System.exit(-1);
	}
	String oAuthConsumerKey = properties.getProperty("oauth.consumerSecret","");
	String oAuthConsumerSecret = properties.getProperty("oauth.consumerKey","");
	configurationBuilder.setOAuthConsumerKey(oAuthConsumerKey);
	configurationBuilder.setOAuthConsumerSecret(oAuthConsumerSecret);
		
	twitterException 	= null;
	twitterStream 		= new TwitterStreamFactory(configurationBuilder.build()).getInstance();
	statusListener 		= new MyTwitterStatusListener(this);
	connectionListener 	= new MyTwitterConnectionLifeCycleListener(this);
	twitterStream.addListener(statusListener);
	twitterStream.addConnectionLifeCycleListener(connectionListener);
}
private boolean isAuthorizationEnabled(){
	return twitterStream.getAuthorization().isEnabled();
}
public void startUserStream()throws TwitterException, InterruptedException{
	//check if authorization is set..
	if(isAuthorizationEnabled()){
		twitterStream.user();
	}
	else{
		try {
			AccessToken accessToken = getAccessToken();
			saveAccessToken(accessToken);
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	while(!isStreamOn && twitterException!=null ){
		Thread.sleep(10000);		
	}
	if(twitterException!=null){
		throw twitterException;	
		}
}

private AccessToken getAccessToken() throws TwitterException, URISyntaxException, IOException{
	Twitter twitter = new TwitterFactory(configurationBuilder.build()).getInstance();
	RequestToken requestToken = twitter.getOAuthRequestToken();
	Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
	AccessToken accessToken = twitter.getOAuthAccessToken(requestToken);
	return accessToken;
}
private void saveAccessToken(AccessToken accessToken) throws IOException{
	String userName = accessToken.getScreenName();
	File file = new File(USER_ACCESS_DIR + userName);
	if(file.createNewFile()){
		Properties prop = new Properties();
		prop.setProperty("oauth.consumerKey", accessToken.getToken());
        prop.setProperty("oauth.consumerSecret", accessToken.getTokenSecret());
        OutputStream os = new FileOutputStream(file);
        prop.store(os, "access token for the user ::" + userName);
	}	
}
public void startStatusStream()throws TwitterException,InterruptedException{
	if(predicates == null){
		throw new TwitterException("predicates not set");
	}	
	FilterQuery filter = new FilterQuery();
	filter.track(predicates.toArray(new String[1]));
	twitterStream.filter(filter);
	while(!isStreamOn && twitterException!=null){
		Thread.sleep(10000);		
	}
	if(twitterException!=null){
		throw twitterException;	
	}
}
	public static void main(String[] args){	
		
	}
	
}
