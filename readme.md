
# Corresponding Chess

1. POST (player names, random colour: Y,N) - start a new game. Return (ID, player names with colours).
2. POST (ID, colour, move) - play a move.
3. GET (ID). Return: (players, colours, moves).

Deployed in Docker container  
REST API  
Send request with a game ID and a move (for example Nxf3+). Get response with opponent's move (if the move is legal).  
Save all moves in the database.  
Tests (Cucumber?)  
Git  
Java 8?  
Gradle  

