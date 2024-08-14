[Home](index.md)
# Enhancement Three: Databases

## Enhancement Breakdown:

### Main():  

| Source      | Code                                                                                                                                |
| ----------  | ----------------------------------------------------------------------------------------------------------------------------------- |
| `Original`  | [Original Artifact](/software_engineering_and_design/Project2_C++_CS410.cpp){:target="_blank"}                                      |
| `Enhanced 1`| [Software Engineering and Design](/software_engineering_and_design/capstone/src/main/java/com/capstone/Main.java){:target="_blank"} |
| `Enhanced 2`| [Algorithms and Data Structures](/algorithms_and_data_structures/capstone/src/main/java/com/capstone/Main.java){:target="_blank"}   |
| `Enhanced 3`| [Databases](/databases/capstone/src/main/java/com/capstone/Main.java){:target="_blank"}                                             |

### Classes:  

| Class               | Code                                                                                                     |
| ------------------- | -------------------------------------------------------------------------------------------------------- |
| `Client()`          | [client-class](/databases/capstone/src/main/java/com/capstone/Client.java){:target="_blank"}             |
| `InputValidtors()`  | [input-valid](/databases/capstone/src/main/java/com/capstone/InputValidators.java){:target="_blank"}     |
| `DbConnection()`    | [db-connect](/databases/capstone/src/main/java/com/capstone/DbConnection.java){:target="_blank"}         |
| `ClientManager()`   | [client-manage](/databases/capstone/src/main/java/com/capstone/ClientManager.java){:target="_blank"}     |

#### Client():

#### InputValidators():

No changes have been made to this class.

#### DbConnection():

#### ClientManager():

## Database:


## Objectives Met:
Through these enhancements, I have met the following course objectives:

- Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals.
- Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution while managing the trade-offs involved in design choices.  
- Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources.

## Reflection and Challenges:
The biggest challenge I’m still dealing with is coming up with a way to allow for a user to delete a client without causing key collisions. For an example, let’s say I have a map with five records, and I delete the client 
with the ID/Key equal to 2. Based on the code that I have written, if I created a new client there would be two clients with an ID of 5. I have thought through this problem and have implemented a solution in the next enhancement. 


[Home](index.md)
