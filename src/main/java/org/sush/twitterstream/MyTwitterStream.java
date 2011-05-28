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

import java.util.Set;

import twitter4j.ConnectionLifeCycleListener;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public class MyTwitterStream {
	
private TwitterStream twitterStream;

private StatusListener statusListener;

private ConnectionLifeCycleListener connectionListener;

private TwitterException twitterException;

private boolean isStreamOn;

private Set<String> predicates;


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

public void init(){
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setUser("supra3012");
	cb.setPassword("shcs2knps2k2");
	twitterException 	= null;
	twitterStream 		= new TwitterStreamFactory(cb.build()).getInstance();
	statusListener 		= new MyTwitterStatusListener(this);
	connectionListener 	= new MyTwitterConnectionLifeCycleListener(this);
	twitterStream.addListener(statusListener);
	twitterStream.addConnectionLifeCycleListener(connectionListener);
}

public void startUserStream()throws TwitterException{
	twitterStream.user();
	while(isStreamOn){
		if(twitterException!=null){
			throw twitterException;	
		}		
	}
}

public void startStatusStream()throws TwitterException{
	twitterStream.user();
	while(isStreamOn){
		if(twitterException!=null){
			throw twitterException;	
		}		
	}
}

	public static void main(String[] args){

		
		
	}
	
	
	
}
