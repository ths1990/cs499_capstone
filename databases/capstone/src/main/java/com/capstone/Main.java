package com.capstone;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.client.MongoDatabase;
//import org.bson.types.ObjectId;
//import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Main {
    // private static ArrayList<Clients> clients = new ArrayList<>();
    private static Map<Integer, Client> clients = new HashMap<>();

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

    public static void LoadClients(){
        DbConnection.connect();

        MongoDatabase database = DbConnection.getDatabase("capstone-database-enhancement");
        MongoCollection<Client> collection = DbConnection.getCollection("capstone-database-enhancement", "clients", Client.class);  
        
        for(Client client : collection.find()){
            clients.put(client.getClientId(), client);

            //Debugging the database load to ensure client names are loading
           // System.out.println("Loaded client:" + client.getName());
        }
    }
    
    
    // Using hardcoded clients for now to test the program
    // public static void LoadClients(){
    //     clients.put(1, new Clients(new ObjectId(),1, "Bob Jones", 1));
    //     clients.put(2, new Clients(new ObjectId(), 2, "Sarah Davis", 2));
    //     clients.put(3, new Clients((3, "Amy Friendly", 1));
    //     clients.put(4, new Clients(4, "Johny Smith", 1));
    //     clients.put(5, new Clients(5, "Carol Spears", 2));
    // }

    public static void DisplayMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. DISPLAY all clients.");
        System.out.println("2. CREATE a new client.");
        System.out.println("3. CHANGE a client's choice.");
        System.out.println("4. EXIT the program.");
    }
    
    // public static void DisplayClients(){
    //     System.out.println("ID Client's Name    Service Selected (1 = Brokerage, 2 = Retirement)\"");
    //     for(Clients client : clients){
    //         System.out.println(client.getClientId() + ". " + client.getName() + " - " + client.getServiceCode());
    //     }
    // }

    public static void DisplayClients(){
        System.out.println("ID Client's Name    Service Selected (1 = Brokerage, 2 = Retirement)\"");
        for(Map.Entry<Integer, Client> entry : clients.entrySet()){
            Client client = entry.getValue();
            System.out.println(client.getClientId() + ". " + client.getName() + " - " + client.getServiceCode());
        }
    }

    // public static void CreateClient(){
    //     int serviceCode;
    //     System.out.println("Enter the client's name: ");
    //     String name = InputValidators.validateNameInput();
    //     System.out.println("Enter the service code (1 = Brokerage, 2 = Retirement): ");
    //     while(true){
    //         serviceCode = InputValidators.validateNumericInput();
    //         if(serviceCode == 1 || serviceCode == 2){
    //             break;
    //         } else{
    //             System.out.println("Invalid service code. Please enter 1 for Brokerage or 2 for Retirement.");
    //         }
    //     }
    //     int clientId = clients.size() + 1;
    //     int key = clientId;
    //     clients.put(key, new Clients(clientId, name, serviceCode));
    //     System.out.println("Client " + name + " has been added with ID " + clientId);
    // }

    public static void ChangeClientChoice (int id){

        Client client = clients.get(id);
        if(client != null){
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
        } else{
            System.out.println("Client not found.");
        }

    }

    // public static void DeleteClient(){
    //     System.out.println("Enter the ID of the client you would like to delete: ");
    //     int clientId = InputValidators.validateNumericInput();
    //     Clients client = clients.get(clientId);
    //     if(client != null){
    //         System.out.println("Are you sure you want to delete " + client.getName() + "? (Y/N)");
    //         String confirmation = InputValidators.validateYesNoInput();
    //         if(confirmation.equalsIgnoreCase("Y")){
    //             clients.remove(clientId);
    //             System.out.println("Client " + client.getName() + " has been deleted.");
    //         } else{
    //             System.out.println("Client deletion cancelled.");
    //         }
    //     } else{
    //         System.out.println("Client not found.");
    //     }
    // }

    // public static void ChangeClientChoice(int id){
    //     // Find the client by client ID
    //     Clients client = clients.stream().filter(c -> c.getClientId() == id).findFirst().orElse(null);
    //     if(client != null){
    //         System.out.println("Enter the new service code (1 = Brokerage, 2 = Retirement) for " + client.getName() + ": ");
    //         int serviceCode;
    //         int oldServiceCode = client.getServiceCode();
    //         while(true){
    //             serviceCode = InputValidators.validateNumericInput();
    //             // Check to see if serviceCode input is a valid choice
    //             if(serviceCode == 1 || serviceCode == 2){
    //                 // Check if the client's choice is already set to the new service code
    //                 if(serviceCode == oldServiceCode){
    //                     System.out.println("Client's choice is already set to " + serviceCode + ". Please enter a different service code.");
    //                 } else
    //                 break; // Exit the loop if a valid service code is entered
    //             } 
    //             else {
    //                 System.out.println("Invalid service code. Please enter 1 for Brokerage or 2 for Retirement.");
    //             }
    //         }
    //
    //         client.setServiceCode(serviceCode);
    //         System.out.println("Client's choice has been updated from " + oldServiceCode + " to " + serviceCode);
    //     } else{
    //         System.out.println("Client not found.");
    //     }
    // }


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

         LoadClients();
         
         while(choice !=4){
            DisplayMenu();
            choice = InputValidators.validateNumericInput();
            switch(choice){
                case 1:
                    DisplayClients();
                    break;
                case 2:
                    //CreateClient();
                    break;
                case 3:
                    System.out.println("Enter the ID of the client you would like to change: ");
                    int clientId = InputValidators.validateNumericInput();
                    ChangeClientChoice(clientId);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    DbConnection.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
         }
    }
}