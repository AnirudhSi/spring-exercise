package com.project.TwitterDemo;

import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterStatusReader {

  public void getHundredTweets(Twitter twitter) {
    try {
      List<Status> statuses;
      String user;

      user = "realdonaldtrump";
      statuses = twitter.getUserTimeline(user);

      System.out.println("Showing @" + user + "'s user timeline.");
      int i = 0;
      for (Status status : statuses) {
        i++;
        System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
      }
      System.out.println("Count: " + i);
    } catch (TwitterException te) {
      te.printStackTrace();
      System.out.println("Failed to get timeline: " + te.getMessage());
      System.exit(-1);
    }
  }

}
