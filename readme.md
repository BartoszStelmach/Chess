http://localhost:8080/swagger-ui/index.html

# Corresponding Chess

1. POST (player names, random colour: Y,N) - start a new game. Return (ID, player names with colours).
2. POST (ID, colour, move) - play a move.
3. GET (ID). Return: (players, colours, moves).

## Moves notation
1. All moves:
   - have length [2-7]
   - end with [+] if they check
   - end with [#] if they mate

2. Pawn moves:  
   - start with [a-h]
   - are followed with [1-8] if they don't take
   - are followed with [x] if they do take
   - end with [a-h][1-8] if they take and don't promote
   - end with [=][QBNR] if they promote  
   a) Not taking and not promoting - 2 chars: [a-h][1-8]  
   - and checking or mating - 3 chars: [a-h][1-8][+#]  
   b) Not taking and promoting - 4 chars: [a-h][1-8][=][QBNR]  
   - and checking or mating - 5 chars: [a-h][1-8][=][QBNR][+#]  
   c) Taking and not promoting - 4 chars: [a-h][x][a-h][1-8]  
   - and checking or mating - 5 chars: [a-h][x][a-h][1-8][+#]  
   d) Taking and promoting - 6 chars: [a-h][x][a-h][1-8][=][QBNR]
   - and checking or mating - 7 chars: [a-h][x][a-h][1-8][=][QBNR][+#]

## Technologies
Deployed in Docker container  
REST API  
Send request with a game ID and a move (for example Nxf3+). Get response with opponent's move (if the move is legal).  
Save all moves in the database.  
Tests (Cucumber?)  
Git  
Java 8?  
Gradle