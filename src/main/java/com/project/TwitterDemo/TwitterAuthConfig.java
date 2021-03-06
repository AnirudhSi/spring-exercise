package com.project.TwitterDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:twitterauth.properties")
@Configuration
public class TwitterAuthConfig {

  @Value("${oauth.consumerKey}")
  private String consumerKey;

  @Value("${oauth.consumerSecret}")
  private String consumerSecret;

  @Value("${oauth.accessToken}")
  private String accessToken;

  @Value("${oauth.accessTokenSecret}")
  private String accessTokenSecret;

  public String getConsumerKey() {
    return consumerKey;
  }

  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessTokenSecret() {
    return accessTokenSecret;
  }

  public void setAccessTokenSecret(String accessTokenSecret) {
    this.accessTokenSecret = accessTokenSecret;
  }

}
