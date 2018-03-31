package com.project.TwitterDemo;

import java.util.List;
import org.ektorp.CouchDbConnector;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
@Configurable
public class TwitterStatusReader {


  public void getHundredTweets() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(TwitterDemoApplication.class);
    TwitterMain twittermain = ctx.getBean(TwitterMain.class);
    CouchDBUtil couchDButil = ctx.getBean(CouchDBUtil.class);
    Twitter twitter = twittermain.getInstance();
    try {
      List<Status> statuses;
      String user;
      user = "jk_rowling";
      statuses = twitter.getUserTimeline(user);

      System.out.println("Showing @" + user + "'s user timeline.");
      for (Status status : statuses) {
        TwitterStatus twitterStatus = new TwitterStatus(status);
        CouchDbConnector connector = couchDButil.getCouchDBConnector(user);
        connector.create(twitterStatus);
      }

    } catch (TwitterException te) {
      te.printStackTrace();
      System.out.println("Failed to get timeline: " + te.getMessage());
      System.exit(-1);
    }
  }



}
