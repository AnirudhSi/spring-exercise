package com.project.TwitterDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component
@Configurable
public class TwitterMain {

  Twitter twitter;

  @Autowired
  protected TwitterAuthConfig twitterConfig;

  @Autowired
  public TwitterAuthConfig getTwitterConfig() {
    return twitterConfig;
  }

  @Autowired
  public void setTwitterConfig(TwitterAuthConfig twitterConfig) {
    this.twitterConfig = twitterConfig;
  }

  public Twitter getInstance() {
    if (twitter == null) {
      ConfigurationBuilder cb = new ConfigurationBuilder();
      cb.setDebugEnabled(true).setOAuthConsumerKey(twitterConfig.getConsumerKey())
          .setOAuthConsumerSecret(twitterConfig.getConsumerSecret())
          .setOAuthAccessToken(twitterConfig.getAccessToken())
          .setOAuthAccessTokenSecret(twitterConfig.getAccessTokenSecret())
          .setTweetModeExtended(true);

      twitter = new TwitterFactory(cb.build()).getInstance();
    }
    return twitter;
  }
}
