import java.util.*;
public class Execute {

	public static void main(String args[])
    {
        String topic = "Amazon";
        ArrayList<String> tweets = TweetManager.getTweets(topic);
        // Pre processing of tweets to remove URLs and usernames
        for(int i = 0; i<tweets.size(); i++)
        {
        	String temp = tweets.get(i);
        	if(temp.contains("http") || temp.contains("#") || temp.contains("@"))
        	{
        		String[] words = temp.split(" ");
        		for(int j = 0; j< words.length; j++)
        		{
        			if (temp.contains("http") || temp.contains("#") || temp.contains("@"))
        				words[j] = "";
        		}
        		temp = String.join(" ",words);
        		temp.replaceAll("\\s+"," ");
        	}
        	tweets.set(i, temp);
        }
        System.out.println("Total number of tweets: " + tweets.size());
        NLP.init();
        double sum = 0;
        for(String tweet : tweets) {
        	int x = NLP.findSentiment(tweet);
        	sum += x; 
        }
        sum = sum/tweets.size();
        System.out.println("Sentiment rating " + sum);
    }
}
