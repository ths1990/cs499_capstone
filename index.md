# cs499_capstone
Professional self-assessment here

<details close>
<summary>
  <h2>Code Review</h2>
</summary>
<iframe width="560" height="315" src="https://www.youtube.com/embed/xiE6kq0efdw?si=bP_jDyBY5pIpI4KI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
</details>

<details close>
  <summary>
    <h2>Enhancement One: Software Engineering and Design</h2>
  </summary>
      I rewrote the code from C++ into Java and created separate classes for a more modular design. Successfully transferring the code between these two languages showcased my ability to first understand the logic of how the code works as well as my understanding of the syntax between the two languages to achieve parity between the original artifact and the enhancement. Creating separate classes showcases my understanding and implementing best practices for Object Oriented Programming (OOP).

<details markdown="block" close>
```cpp
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
 ```
														      </details>

Through these enhancements, I have met the course objectives that I planned to meet in Module One which I have listed below:  

  
- Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals.
- Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources.
  
I really enjoyed making these initial enhancements, and it went a lot smoother than I anticipated. I had to brush up on Java again, since many of my past courses used C++. One of the main challenges I faced was understanding how input worked in Java versus C++ using the Scanner class.

</details>

<details close>
  <summary>
    <h2>Enhancement Two: Algorithms and Data Structure</h2>
  </summary>
  Add Narrative
</details>


<details close>
  <summary>
   <h2>Enhancement Three: Databases</h2>
  </summary>
  Add narrative
</details>
