package twitterStuff;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;

public class Main {
	public static void main(String[] args){
		String consumerKey = "h2uWk7fgPgQ3MynvchEg";
		String consumerSecret = "44GkMpRE2XcMsDPbla5GxVDGbCYmvNOqfedkwKHyc7w";
		String accessToken = "1938581365-E263zeV3UhB8iCvDX8p5OveQsGgj0GlTPhuqUMf";
		String accessTokenSecret = "7QAzC9JnVrhqB0v0ds7Oqa2d6fxsw8qxHyKSCD0U";
		
		OAuthSignpostClient oauthClient = new OAuthSignpostClient(consumerKey, 
		consumerSecret, accessToken,
		accessTokenSecret);

		// 2. Make a Twitter object
		Twitter twitter = new Twitter("my-name", oauthClient);
		
		//Save the status, hard-coded right now
		String status = "Also, on that note, a big plant-shout out to @Twilio for the free Phone credit. Much appreciated! #HackMIT";
		System.out.println(status); //print the status
		
		twitter.setStatus(status); //set the status
	}
	
}
