# Enhancement One: Software Engineering and Design

I rewrote the code from C++ into Java and created separate classes for a more modular design. Successfully transferring the code between these two languages showcased my ability to first understand the logic of how the code works as well as my understanding of the syntax between the two languages to achieve parity between the original artifact and the enhancement. Creating separate classes showcases my understanding and implementing best practices for Object Oriented Programming (OOP).

## Enhancement Breakdown:

### Main():

In the Main Java class, I ported most of the functionality from the original artificat straight to Java. I converted the original list of variables in the C++ code into an ArrayList structure - this way the client ID, name, and service code are all associated with a singular object and not tied to individual variables. 

<table>
<tr>
<th>Original Code</th>
<th>Enhanced</th>
</tr>
<tr>
<td>

```cpp

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

```

</td>
<td>

```java
public static void LoadClients(){
   clients.add(new Clients(1, "Bob Jones", 1));
   clients.add(new Clients(2, "Sarah Davis", 2));
   clients.add(new Clients(3, "Amy Friendly", 1));
   clients.add(new Clients(4, "Johny Smith", 1));
   clients.add(new Clients(5, "Carol Spears", 2));
 }

```

</td>
</tr>
</table>


### Client Class:

I created a Class file for clients. This encapsulates the data stored within the Client class, preventing unauthorized access to the class 
while also making the code more readable, flexible and reusable. 

```java
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
```

### Input Validation Class:

In the original code, all of the methods were stored in the main cpp file. However, in the same spirit of making the Client it's own separate class file, I did the same for the various InputValidation methods from the original code. 

### Additional Enhancements:

Since I used the same artifact for all three enhancements in this project, I added additional enhancments in this area that are featured in [software_engineering_and_design](/software_engineering_and_design/capstone/src/main/java/com/capstone/Main.java) I added addtional methods to Create and Deactivate clients - adding a boolean field to the Client class to indicate whether a client is active or not. I moved all methods around doing anything with the Client into its own separate class file called ClientManager. 


Through these enhancements, I have met the course objectives that I planned to meet in Module One which I have listed below:  

  
- Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals.
- Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources.
  
I really enjoyed making these initial enhancements, and it went a lot smoother than I anticipated. I had to brush up on Java again, since many of my past courses used C++. One of the main challenges I faced was understanding how input worked in Java versus C++ using the Scanner class.
