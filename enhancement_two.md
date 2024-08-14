[Home](index.md)
# Enhancement Two: Algorithms and Data Structure

In the category of Algorithms and Data Structure, I have implemented a Map to store and access client information, using the
Client class I created in the last Milestone. With the Map interface, each client object created is mapped to a key – in the 
code I created the key is also the clientID. When a new client object is created, the clientID is equal to the number of 
records stored in the map incremented by one so that the ID continues to grow. When it comes to updating the client, the user 
needs to perform a search to find the client. Using the clientId as the key, finding the client the user needs to update is 
very efficient. Compared to the original C++ code, where these values were a series of variables not truly mapped to the 
client, this code is better designed.

## Enhancement Breakdown:

### Main():
| Source     | Code                                                                                                                                |
| ---------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| Original   | [Original Artifact](/software_engineering_and_design/Project2_C++_CS410.cpp){:target="_blank"}                                      |
| Enhanced 1 | [Software Engineering and Design](/software_engineering_and_design/capstone/src/main/java/com/capstone/Main.java){:target="_blank"} |
| Enhanced 2 | [Algorithms and Data Structures](/algorithms_and_data_structures/capstone/src/main/java/com/capstone/Main.java){:target="_blank"}   |

All of the enhancements made for this category were made in the Main class. I took what I wrote for Enhancement One and made a few key changes. First I replaced the Clients ArrayList with a Map. The key-value structure allows for an efficient search algorithm for finding and changing a client's service code. I had to re-write the LoadClients(), DisplayClients(), and ChangeClientChoice() methods to be compatible with the Map strucutre. Additionaly, I wrote a method CreateClient() to add to the Client Map.

### Classes:
No new class files were created for this enhancement.

## Objectives Met:
Through these enhancements, I have met the following course objectives:

- Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals.
- Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution while managing the trade-offs involved in design choices.  
- Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources.

## Reflection and Challenges:
The biggest challenge I’m still dealing with is coming up with a way to allow for a user to delete a client without causing key collisions. For an example, let’s say I have a map with five records, and I delete the client 
with the ID/Key equal to 2. Based on the code that I have written, if I created a new client there would be two clients with an ID of 5. I have thought through this problem and have implemented a solution in the next enhancement. 

[Enhancement Three](enhancement_three.md)

[Home](index.md)
