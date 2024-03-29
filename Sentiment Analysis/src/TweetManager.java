import java.util.*;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetManager {

    public static ArrayList<String> getTweets(String topic) {

        Twitter twitter = new TwitterFactory().getInstance();
        ArrayList<String> tweetList = new ArrayList<String>();
        try {
            Query query = new Query(topic);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    tweetList.add(tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        return tweetList;
    }
    	// test the module
    	public static void main(String args[])
    	{
    		ArrayList<String> list = getTweets("Paris");
    		Iterator<String> it = list.iterator();
    		while(it.hasNext())
    		{
    			System.out.println(it.next());
    			System.out.println("---------------------------------------------");
    		}
    	}
}