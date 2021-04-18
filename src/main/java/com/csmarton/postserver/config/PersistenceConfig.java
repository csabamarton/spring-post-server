package com.csmarton.postserver.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class PersistenceConfig extends AbstractMongoClientConfiguration {

    @Value("${mongo.url}")
    private String dbUri;
    @Value("${db.name}")
    private String dbName;
    @Value("${spring.data.mongodb.auto-index-creation}")
    private Boolean indexedMongo;

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(this.dbUri + "/" + this.dbName);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return this.dbName;
    }

    @Override
    protected boolean autoIndexCreation() {
        return this.indexedMongo;
    }
}
