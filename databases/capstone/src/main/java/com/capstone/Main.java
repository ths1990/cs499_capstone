package com.capstone;

//MongoDB imports
import com.mongodb.client.MongoDatabase;


public class Main {
    
    private static MongoDatabase database;
   

    private static void InitializeDatabase(){
        DbConnection.connect();
        database = DbConnection.getDatabase("capstone-database-enhancement");
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

    public static void DisplayMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. DISPLAY clients.");
        System.out.println("2. CREATE a new client.");
        System.out.println("3. CHANGE a client's choice.");
        System.out.println("4. REACTIVATE/DEACTIVATE a client.");
        System.out.println("5. EXIT the program.");
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
         ClientManager.InitializeCollection();
         ClientManager.LoadClients();
         
         while(choice !=5){
            DisplayMenu();
            int clientId;
            choice = InputValidators.validateNumericInput();
            switch(choice){
                case 1:
                    System.out.println("Display: 1) All Clients 2) Active Clients 3) Inactive Clients");
                    int filter = InputValidators.validateNumericInput();
                    ClientManager.DisplayClients(filter);
                    break;
                case 2:
                    ClientManager.CreateClient();
                    break;
                case 3:
                    System.out.println("Enter the ID of the client you would like to change: ");
                    clientId = InputValidators.validateNumericInput();
                    ClientManager.ChangeClientChoice(clientId);
                    break;
                case 4:
                    System.out.println("Enter the ID of the client you would like to change: ");
                    clientId = InputValidators.validateNumericInput();
                    ClientManager.ChangeActiveStatus(clientId);
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