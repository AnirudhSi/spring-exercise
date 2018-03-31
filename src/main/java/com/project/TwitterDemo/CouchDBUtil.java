package com.project.TwitterDemo;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class CouchDBUtil {

  CouchDbInstance dbInstance = null;


  // Returns handle for actual coucbDB instances.
  public CouchDbInstance getCouchDBInstance() {
    if (dbInstance == null) {
      HttpClient httpClient = null;
      try {
        httpClient = new StdHttpClient.Builder().url("http://localhost:5984").username("admin")
            .password("admin").build();
      } catch (Exception e) {

      }
      dbInstance = new StdCouchDbInstance(httpClient);
    }
    return dbInstance;

  }

  public CouchDbConnector getCouchDBConnector(String dbName) {
    dbInstance = getCouchDBInstance();
    CouchDbConnector dbConnector = dbInstance.createConnector(dbName, true);
    return dbConnector;
  }

}
