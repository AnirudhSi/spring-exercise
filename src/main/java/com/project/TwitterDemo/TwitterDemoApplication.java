package com.project.TwitterDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterDemoApplication {

  public static void main(String[] args) {
    TwitterStatusReader reader = new TwitterStatusReader();
    reader.getHundredTweets();
  }
}
