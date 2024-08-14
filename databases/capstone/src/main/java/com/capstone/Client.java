package com.capstone;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Client {
    @BsonProperty("_id")
    private ObjectId id;

    @BsonProperty("clientId")
    private int clientId;

    @BsonProperty("clientName")
    private String name;

    @BsonProperty("serviceCode")
    private int serviceCode;

    @BsonProperty("isActive")
    private boolean isActive;

    // No-argument constructor
    public Client() {}

    // Parameterized constructor
    public Client(ObjectId id, int clientId, String name, int serviceCode,boolean isActive) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.serviceCode = serviceCode;
        this.isActive = isActive;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}