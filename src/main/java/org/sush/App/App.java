package org.sush.App;

import java.io.IOException;

import org.sush.twitterstream.MyTwitterStream;

import twitter4j.TwitterException;

public class App {
	public static void main(String[] args){
		MyTwitterStream mts = new MyTwitterStream();
		try {
			mts.init();
			mts.startUserStream();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TwitterException e) {			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
