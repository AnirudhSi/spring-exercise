package com.project.TwitterDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import twitter4j.Twitter;

@SpringBootApplication
public class TwitterDemoApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(TwitterDemoApplication.class);
    TwitterUtil con = ctx.getBean(TwitterUtil.class);
    Twitter twitter = con.getInstance();
    TwitterStatusReader reader = new TwitterStatusReader();
    reader.getHundredTweets(twitter);
  }
}
