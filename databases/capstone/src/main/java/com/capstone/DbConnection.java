package com.capstone;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class DbConnection {
    private static String username = System.getenv("MONGO_USERNAME");
    private static String password = System.getenv("MONGO_PASSWORD");
    private static String connectionString = "mongodb+srv://" + username + ":" + password + "@cs499-capstone.flrqbmy.mongodb.net/?retryWrites=true&w=majority&appName=cs499-capstone";
    private static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();
    private static MongoClient mongoClient = null;

    public static void connect() {
        try {
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(pojoCodecProvider)
            );

            ConnectionString connString = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .serverApi(serverApi)
                    .codecRegistry(pojoCodecRegistry)
                    .build();
            mongoClient = MongoClients.create(settings);
            System.out.println("Connected to MongoDB!");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public static MongoDatabase getDatabase(String dbName) {
        if (mongoClient == null) {
            connect();
        }
        return mongoClient.getDatabase(dbName);
    }

    public static <T> MongoCollection<T> getCollection(String dbName, String collectionName, Class<T> clazz) {
        MongoDatabase database = getDatabase(dbName);
        return database.getCollection(collectionName, clazz);
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}