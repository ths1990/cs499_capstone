[Home](index.md)
# Enhancement Two: Algorithms and Data Structure

In the category of Algorithms and Data Structure, I have implemented a Map to store and access client information, using the
Client class I created in the last Milestone. With the Map interface, each client object created is mapped to a key – in the 
code I created the key is also the clientID. When a new client object is created, the clientID is equal to the number of 
records stored in the map incremented by one so that the ID continues to grow. When it comes to updating the client, the user 
needs to perform a search to find the client. Using the clientId as the key, finding the client the user needs to update is 
very efficient. Compared to the original C++ code, where these values were a series of variables not truly mapped to the 
client, this code is better designed.

[Enhancement Three](enhancement_three.md)

[Home](index.md)
