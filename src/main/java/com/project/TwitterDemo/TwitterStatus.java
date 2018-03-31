package com.project.TwitterDemo;

import org.ektorp.support.CouchDbDocument;
import twitter4j.Status;

public class TwitterStatus extends CouchDbDocument {

  public TwitterStatus(Status status) {
    this.status = status;
  }

  Status status;

  public void setStatus(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

}
