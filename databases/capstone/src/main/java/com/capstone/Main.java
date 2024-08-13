package com.capstone;

//Map imports
import java.util.HashMap;
import java.util.Map;

//MongoDB imports
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class Main {
    private static Map<Integer, Client> clients = new HashMap<>();
    private static MongoDatabase database;
    private static MongoCollection<Client> collection;

    private static void InitializeDatabase(){
        DbConnection.connect();
        database = DbConnection.getDatabase("capstone-database-enhancement");
        collection = DbConnection.getCollection("capstone-database-enhancement", "clients", Client.class);
    }

    public static boolean CheckPermission(){
        System.out.println("Enter your username: ");
        String username  = InputValidators.validateUsername();
        System.out.println("Enter your password: ");
        String password = InputValidators.validatePassword();

        // Using a hardcoded password for now to test the login functionality
        if(password.equals("password")){
            System.out.println("Welcome " + username + "!");
            return true;
        } else{
            return false;
        }
    }
// Load clients from the database into a HashMap
    public static void LoadClients(){
        for(Client client : collection.find()){
            clients.put(client.getClientId(), client);
            //Debugging the database load to ensure client names are loading
           // System.out.println("Loaded client:" + client.getName());
        }
    }

    public static void DisplayMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. DISPLAY clients.");
        System.out.println("2. CREATE a new client.");
        System.out.println("3. CHANGE a client's choice.");
        System.out.println("4. REACTIVATE/DEACTIVATE a client.");
        System.out.println("5. EXIT the program.");
    }

    public static void DisplayClients(int filter) {
        System.out.printf("%-5s %-20s %-30s%n", "ID", "Client's Name", "Service Selected (1 = Brokerage, 2 = Retirement)");
        for (Map.Entry<Integer, Client> entry : clients.entrySet()) {
            Client client = entry.getValue();
            boolean shouldDisplay = false;
    
            switch (filter) {
                case 1:
                    shouldDisplay = true; // Display all clients
                    break;
                case 2:
                    shouldDisplay = client.isActive(); // Display active clients
                    break;
                case 3:
                    shouldDisplay = !client.isActive(); // Display inactive clients
                    break;
                default:
                    System.out.println("Invalid filter option.");
                    return;
            }
    
            if (shouldDisplay) {
                System.out.printf("%-5d %-20s %-30d%n", client.getClientId(), client.getName(), client.getServiceCode());
            }
        }
    }

    public static void CreateClient(){
        int serviceCode;
        System.out.println("Enter the client's name: ");
        String name = InputValidators.validateNameInput();
        System.out.println("Enter the service code (1 = Brokerage, 2 = Retirement): ");
        while(true){
            serviceCode = InputValidators.validateNumericInput();
            if(serviceCode == 1 || serviceCode == 2){
                break;
            } else{
                System.out.println("Invalid service code. Please enter 1 for Brokerage or 2 for Retirement.");
            }
        }
        int clientId = clients.size() + 1;
        Client newClient = new Client(new ObjectId(), clientId, name, serviceCode,true);
        collection.insertOne(newClient);
        clients.put(clientId, newClient);
        
        System.out.println("Client " + name + " has been added with ID " + clientId);

        
    }

    public static void ChangeClientChoice (int id){

        Client client = clients.get(id);
        if(client != null){
            if (!client.isActive()) {
                System.out.println(client.getName() + " is inactive. Service code cannot be updated.");
                return;
            }
            System.out.println("Enter the new service code (1 = Brokerage, 2 = Retirement) for " + client.getName() + ": ");
            int serviceCode;
            int oldServiceCode = client.getServiceCode();
            while(true){
                serviceCode = InputValidators.validateNumericInput();
                if(serviceCode == 1 || serviceCode == 2){
                    if(serviceCode == oldServiceCode){
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
            collection.updateOne(query,update);

        } else{
            System.out.println("Client not found.");
        }
    }

    public static void ChangeActiveStatus(int id) {
        Client client = clients.get(id);
        if (client != null) {
            boolean newStatus = !client.isActive();
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

    public static void main(String[] args) {

        int MAX_ATTEMPTS = 3; // Maximum number of login attempts
        int loginAttempts = 0; // Keeps track of login attempts
        boolean authenticated = false;
        int choice = 0;

         System.out.println("Welcome to the Capstone Project!");

         while(!authenticated){
            //Prevent brute force attacks by limiting the number of login attempts
            if(loginAttempts < MAX_ATTEMPTS){
                if(CheckPermission()){
                    authenticated = true;
                } else{
                    loginAttempts++;
                    System.out.println("Invalid username or password. Please try again.");
                    System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts));
                }
            } else{
                System.out.println("Too many failed login attempts. Please try again later.");
            }
         }
         //Once authenticated, initialize the database and load the clients
         InitializeDatabase();
         LoadClients();
         
         while(choice !=5){
            DisplayMenu();
            int clientId;
            choice = InputValidators.validateNumericInput();
            switch(choice){
                case 1:
                    System.out.println("Display: 1) All Clients 2) Active Clients 3) Inactive Clients");
                    int filter = InputValidators.validateNumericInput();
                    DisplayClients(filter);
                    break;
                case 2:
                    CreateClient();
                    break;
                case 3:
                    System.out.println("Enter the ID of the client you would like to change: ");
                    clientId = InputValidators.validateNumericInput();
                    ChangeClientChoice(clientId);
                    break;
                case 4:
                    System.out.println("Enter the ID of the client you would like to change: ");
                    clientId = InputValidators.validateNumericInput();
                    ChangeActiveStatus(clientId);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    DbConnection.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
         }
    }
}