package com.capstone;

import java.util.Map;
import java.util.HashMap;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;


public class ClientManager {
    private static Map<Integer, Client> clients = new HashMap<>();
    private static MongoCollection<Client> collection;

    public static void InitializeCollection() {
        collection = DbConnection.getCollection("capstone-database-enhancement", "clients", Client.class);
    }

    // Load clients from the database into a HashMap
    public static void LoadClients(){
        for(Client client : collection.find()){
            clients.put(client.getClientId(), client);
            //Debugging the database load to ensure client names are loading
           // System.out.println("Loaded client:" + client.getName());
        }
    }

    public static void DisplayClients(int filter) {
        
        //Displays a confirmation message based on the filter selected, then displays the clients
        String message = switch (filter) {
            case 1 -> "Displaying all clients:";
            case 2 -> "Displaying active clients:";
            case 3 -> "Displaying inactive clients:";
            default -> "Invalid filter.";
        };
        System.out.println(message);
        System.out.printf("%-5s %-20s %-30s%n", "ID", "Client's Name", "Service Selected (1 = Brokerage, 2 = Retirement)");
    
        for (Map.Entry<Integer, Client> entry : clients.entrySet()) {
            Client client = entry.getValue();
            boolean shouldDisplay = (filter == 1) || (filter == 2 && client.getIsActive()) || (filter == 3 && !client.getIsActive());
    
            if (shouldDisplay) {
                System.out.printf("%-5d %-20s %-30d%n", client.getClientId(), client.getName(), client.getServiceCode());
            }
        }
    }

    public static void CreateClient() {
        int serviceCode;
        boolean activeStatus = true;
        System.out.println("Enter the client's name: ");
        String name = InputValidators.validateNameInput();
        System.out.println("Enter the service code (1 = Brokerage, 2 = Retirement): ");
        while (true) {
            serviceCode = InputValidators.validateNumericInput();
            if (serviceCode == 1 || serviceCode == 2) {
                break;
            } else {
                System.out.println("Invalid service code. Please enter 1 for Brokerage or 2 for Retirement.");
            }
        }
        int clientId = clients.size() + 1;
        Client newClient = new Client(new ObjectId(), clientId, name, serviceCode, activeStatus);
        collection.insertOne(newClient);
        clients.put(clientId, newClient);

        System.out.println("Client " + name + " has been added with ID " + clientId);
    }

    public static void ChangeClientChoice(int id) {
        Client client = clients.get(id);
        if (client != null) {
            if (!client.getIsActive()) {
                System.out.println(client.getName() + " is inactive. Service code cannot be updated.");
                return;
            }
            System.out.println("Enter the new service code (1 = Brokerage, 2 = Retirement) for " + client.getName() + ": ");
            int serviceCode;
            int oldServiceCode = client.getServiceCode();
            while (true) {
                serviceCode = InputValidators.validateNumericInput();
                if (serviceCode == 1 || serviceCode == 2) {
                    if (serviceCode == oldServiceCode) {
                        System.out.println("Client's choice is already set to " + serviceCode + ". Please enter a different service code.");
                    } else
                        break;
                } else {
                    System.out.println("Invalid service code. Please enter 1 for Brokerage or 2 for Retirement.");
                }
            }
            client.setServiceCode(serviceCode);
            System.out.println("Client's choice has been updated from " + oldServiceCode + " to " + serviceCode);
            Document query = new Document("clientId", id);
            Document update = new Document("$set", new Document("serviceCode", serviceCode));
            collection.updateOne(query, update);
        } else {
            System.out.println("Client not found.");
        }
    }

    public static void ChangeActiveStatus(int id) {
        Client client = clients.get(id);
        if (client != null) {
            boolean newStatus = !client.getIsActive();
            client.setIsActive(newStatus);
            String status = newStatus ? "activated" : "deactivated";
            System.out.println(client.getName() + " has been " + status + ".");

            Document query = new Document("clientId", id);
            Document update = new Document("$set", new Document("isActive", newStatus));
            collection.updateOne(query, update);
        } else {
            System.out.println("Client not found.");
        }
    }
}