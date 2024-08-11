package com.capstone;


public class Clients {
    private int clientId;
    private String name;
    private int serviceCode;

    public Clients(int clientId,String name, int serviceCode) {
        this.clientId = clientId;
        this.name = name;
        this.serviceCode = serviceCode;
    }

    public int getClientId() {
        return clientId;
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

}
