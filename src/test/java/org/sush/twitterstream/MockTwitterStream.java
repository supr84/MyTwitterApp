package org.sush.twitterstream;

import twitter4j.ConnectionLifeCycleListener;
import twitter4j.FilterQuery;
import twitter4j.RateLimitStatusListener;
import twitter4j.SiteStreamsListener;
import twitter4j.StatusListener;
import twitter4j.StatusStream;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.UserStream;
import twitter4j.UserStreamListener;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;

public class MockTwitterStream implements TwitterStream{

	public void getNext(){
		
	}
	public void setOAuthConsumer(String consumerKey, String consumerSecret) {
		// TODO Auto-generated method stub
		
	}

	public RequestToken getOAuthRequestToken() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public RequestToken getOAuthRequestToken(String callbackURL)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken(String oauthVerifier)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken(RequestToken requestToken)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken(RequestToken requestToken,
			String oauthVerifier) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessToken getOAuthAccessToken(String screenName, String password)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOAuthAccessToken(AccessToken accessToken) {
		// TODO Auto-generated method stub
		
	}

	public String getScreenName() throws TwitterException,
			IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public long getId() throws TwitterException, IllegalStateException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addRateLimitStatusListener(RateLimitStatusListener listener) {
		// TODO Auto-generated method stub
		
	}

	public Authorization getAuthorization() {
		// TODO Auto-generated method stub
		return null;
	}

	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addConnectionLifeCycleListener(
			ConnectionLifeCycleListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addListener(UserStreamListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addListener(StatusListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addListener(SiteStreamsListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void firehose(int count) {
		// TODO Auto-generated method stub
		
	}

	public StatusStream getFirehoseStream(int count) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void links(int count) {
		// TODO Auto-generated method stub
		
	}

	public StatusStream getLinksStream(int count) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void retweet() {
		// TODO Auto-generated method stub
		
	}

	public StatusStream getRetweetStream() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void sample() {
		// TODO Auto-generated method stub
		
	}

	public StatusStream getSampleStream() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void user() {
		// TODO Auto-generated method stub
		
	}

	public void user(String[] track) {
		// TODO Auto-generated method stub
		
	}

	public UserStream getUserStream() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserStream getUserStream(String[] track) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void site(boolean withFollowings, long[] follow) {
		// TODO Auto-generated method stub
		
	}

	public void filter(FilterQuery query) {
		// TODO Auto-generated method stub
		
	}

	public StatusStream getFilterStream(FilterQuery query)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

}
