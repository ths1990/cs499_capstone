//============================================================================
// Name        : Project1_C++.cpp
// Author      : Ty Simpson
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <limits>
#include <sstream>


using namespace std;

/*
 * Password, names, and service codes should not be hard-coded
 * and instead should be stored in a secure and encrypted database.
 * Access to what a user can and can't do to the data should be controlled
 * through the authorization principle of least privileges. For instance, only
 * certain users should be able to update customer data.
 */

//Default password, identified from the Assembly Code
string defaultpassword = "123"; //No hard-coded passwords.

/*
 *Customer information, like names and service codes, should not be hardcoded into the program. This information
 *should be stored in a secure database and encrypted to protect sensitive information.
 */

// Names
string name1 = "Bob Jones";
string name2 = "Sarah Davis";
string name3 = "Amy Friendly";
string name4 = "Johny Smith";
string name5 = "Carol Spears";

//Nums - for Service Codes
int num1 = 1;
int num2= 2;
int num3 = 1;
int num4 = 1;
int num5 = 2;

string ValidateUsernameInput(){
	unsigned int MAX_USERNAME_LENGTH = 20; //Maximum username length of 20 characters.
	unsigned int MIN_USERNAME_LENGTH = 4; //Minimum username length of 4 characters.
	string usernameCheck;

	getline(cin,usernameCheck);
		if(usernameCheck.length() > MAX_USERNAME_LENGTH || usernameCheck.length() < MIN_USERNAME_LENGTH){
			cout << "Invalid username. Must be a maximum of " << MAX_USERNAME_LENGTH << " and a minimum of " << MIN_USERNAME_LENGTH << " characters.\n";
			return  "";
		} else{
			return usernameCheck;
		}
}

string ValidatePasswordInput(){
	unsigned int MAX_PASSWORD_LENGTH = 20; //Maximum password length of 20 characters
	unsigned int MIN_PASSWORD_LENGTH = 3; //Minimum password length of 3 character - not a secure standard, but for the scope of this project, set to match the password provided.
	string passwordCheck;

	getline(cin,passwordCheck);
		if(passwordCheck.length() > MAX_PASSWORD_LENGTH || passwordCheck.length() < MIN_PASSWORD_LENGTH){
			cout << "Invalid password format. Must be a maximum of " << MAX_PASSWORD_LENGTH << " and a minimum of " << MIN_PASSWORD_LENGTH << " characters.\n";
			return  "";
		} else{
			return passwordCheck;
		}
}

/*
 * Converts user input into an integer.
 * If the user input is a non-number, conversion cannot happen,
 * and the function prints an error message and requests input again until
 * valid input is received. If user input is a number, the programs returns the input
 * as an integer value.
 */

int ValidateNumericInput(){
	int inputInt;
	string inputString;

	while(true){
		getline(cin,inputString);
		stringstream convert(inputString);

		if(convert >> inputInt){
			return inputInt;
		} else{
			cerr << "Invalid input. Please enter a number: " << endl;
		}
	}
}

int CheckUserPermissionAccess(){
	string username = "";
	string password = "";


	while(true){
	cout << "Enter your username: \n";
	username = ValidateUsernameInput();
	if (username != ""){
		break;
		}
	}
	while(true){
		cout << "Enter your password: \n";
		password = ValidatePasswordInput();
		if(password != ""){
			break;
		}

	}


	if (password == defaultpassword){
		return 1;
	} else {
		return 2;
	}

}
/*
 * This function works for the scope of this project, but following the recommendation of storing
 * customer data in a secure data base, this function should make an API call that Reads all records in the
 * customer database.
 */
void DisplayInfo(){
	cout << "Client's Name    Service Selected (1 = Brokerage, 2 = Retirement)" << "\n";
	cout << "1. " << name1 << " selection option " << num1 << "\n";
	cout << "2. " << name2 << " selection option " << num2 << "\n";
	cout << "3. " << name3 << " selection option " << num3 << "\n";
	cout << "4. " << name4 << " selection option " << num4 << "\n";
	cout << "5. " << name5 << " selection option " << num5 << "\n";

	return;
}

void ChangeCustomerChoice(){
	int changechoice = 0;
	int newservice = 0;

	cout << "Enter the number of the client (1-5) that you wish to change\n";
	changechoice = ValidateNumericInput(); //Calls function to validate input - returns an integer value and assigns it to changechoice variable.

	cout << "Please enter the client's new service choice (1 = Brokerage, 2 = Retirement)\n";
	newservice = ValidateNumericInput(); //Calls function to validate input - returns an integer value and assigns it to newservice variable.

	/*
	 * Switch statement used to ensure user input is a value between 1 and 5.
	 * Any other value, the system will print out a message informing the user the value entered is not valid.
	 *
	 * This works for the scale of this project - but should the customer data be stored in a database, this should
	 * be handled by making an API call to the database to read and update records (the R and U in CRUD).
	 *
	 * A more appropriate use of a switch statement is to handle user selection of a menu.
	 */
	switch(changechoice){

	case 1:
		if(newservice == 1 || newservice == 2){ //If statement confirms that newservice is equal to 1 or 2, then assigns value in newservice to the variable.
			num1 = newservice;
			break;
		}else{
			cout << "Invalid service choice. Please select 1 or 2." << endl; //Any other value than 1 or two, this message is printed.
			break;
		}
	case 2:
		if(newservice == 1 || newservice == 2){
			num2 = newservice;
			break;
		}else{
			cout << "Invalid service choice. Please select 1 or 2." << endl;
			break;
		}
	case 3:
		if(newservice == 1 || newservice == 2){
			num3 = newservice;
			break;
		}else{
			cout << "Invalid service choice. Please select 1 or 2." << endl;
			break;
		}
	case 4:
		if(newservice == 1 || newservice == 2){
			num4 = newservice;
			break;
		}else{
			cout << "Invalid service choice. Please select 1 or 2." << endl;
			break;
		}
	case 5:
		if(newservice == 1 || newservice == 2){
			num5 = newservice;
			break;
		}else{
			cout << "Invalid service choice. Please select 1 or 2." << endl;
			break;
		}
	default:
		cout << "Invalid selection. Please select a customer number, 1 - 5." << endl;
		break;

	}


}

int main() {
    int answer = 0;
	int loginAttempts = 0; //Keeps track of number of attempts.
	int choice = 0; //Default value for choice menu.

	int MAX_ATTEMPTS = 3; //Constant for maximum login attempts


	cout << "A Ty Simpson Product.\n" << "Hello! Welcome to Our Investment Company\n";

	while (answer != 1){
		if (loginAttempts == MAX_ATTEMPTS){ //Once loginAttempts equals MAX_ATTEMPTs, exit the program
			cout << "You have exceeded the maximum number of login attempts. Goodbye." << endl;
			return 0;
		}
		answer = CheckUserPermissionAccess();
		if(answer == 1){
			break;
		}
		else {
			cout << "Invalid Password. Please try again\n";
			loginAttempts++; // At each login fail, increment loginAttempts by 1
			cout << "Attempt " << loginAttempts << " / " << MAX_ATTEMPTS << "\n"; //Print message to alert user of number of attempts

		}
	}

	while (choice != 3){
		cout << "What would you like to do?\n";
		cout << "DISPLAY the client list (enter 1)\n";
		cout << "CHANGE a client's choice (enter 2)\n";
		cout << "Exit the program. (enter 3)\n";

		choice = ValidateNumericInput(); //Ensures user input is a numeric value.
		cout << "You chose " << choice << "\n";

		/*
		 * Switch statement to limit what choices a user can make, tied to the menu options.
		 * Ideal for this particular scenario - with a preset limit of user choices.
		 */
		switch(choice){
			case 1:
				DisplayInfo();
				break;
			case 2:
				ChangeCustomerChoice();
				break;
			case 3:
				cout << "Good-bye" << endl;
				return 1;
				break;
			default:
				cout << "You have selected an invalid option. Please select and option 1-3." << endl;
				break;
		}

	}
}

