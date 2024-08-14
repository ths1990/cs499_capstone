[`Home`](index.md)
# Enhancement One: Software Engineering and Design

I rewrote the code from C++ into Java and created separate classes for a more modular design. Successfully transferring the code between these two languages showcased my ability to first understand the logic of how the code works as well as my understanding of the syntax between the two languages to achieve parity between the original artifact and the enhancement. Creating separate classes showcases my understanding and implementing best practices for Object Oriented Programming (OOP).

## Enhancement Breakdown:

### Main():

| Source                                | Code                                                                                                                   |
| ------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| `Original`                            | [client-original](/software_engineering_and_design/Project2_C++_CS410.cpp){:target="_blank"}                           |
| `Enhanced`                            | [client-enhanced](/software_engineering_and_design/capstone/src/main/java/com/capstone/Main.java){:target="_blank"}    |

In the Main Java class, I ported most of the functionality from the original artificat straight to Java. I converted the original list of variables in the C++ code into an ArrayList structure - this way the client ID, name, and service code are all associated with a singular object and not tied to individual variables. 

### Classes:

| Class                        | Code                                                                                                                         |
| ---------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `Clients()`                  | [client-class](/software_engineering_and_design/capstone/src/main/java/com/capstone/Clients.java){:target="_blank"}          |
|`InputValidtors()`            | [input-valid](/software_engineering_and_design/capstone/src/main/java/com/capstone/InputValidators.java){:target="_blank"}   |

#### Client():
I created a Class file for clients. This encapsulates the data stored within the Client class, preventing unauthorized access to the class 
while also making the code more readable, flexible and reusable. 

#### Input Validation Class:

In the original code, all of the methods were stored in the main cpp file. However, in the same spirit of making the Client it's own separate class file, I did the same for the various InputValidation methods from the original code. 

### Additional Enhancements:

Since I used the same artifact for all three enhancements in this project, I added additional enhancments in this area that are not featured in [software_engineering_and_design](/software_engineering_and_design/capstone/src/main/java/com/capstone/Main.java) while working on the other two categories. I added addtional methods to Create and Deactivate clients - adding a boolean field to the Client class to indicate whether a client is active or not. I moved all methods around doing anything with the Client into its own separate class file called ClientManager. 

## Objectives Met:

Through these enhancements, I have met the course objectives that I planned to meet in Module One which I have listed below:  

  
- Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals.
- Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources.


  
I really enjoyed making these initial enhancements, and it went a lot smoother than I anticipated. I had to brush up on Java again, since many of my past courses used C++. One of the main challenges I faced was understanding how input worked in Java versus C++ using the Scanner class.\
\
[Enhancement Two](enhancement_two.md)\
\
[Home](index.md)
