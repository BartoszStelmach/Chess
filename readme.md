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


## Docker
cd C:\Users\Gosu\IdeaProjects\docker\Chess
dir
docker build --tag java-docker .
docker images
docker run --publish 8080:8080 java-docker
docker run -d -p 8080:8080 java-docker

docker volume create mysql_data
docker volume create mysql_config
docker network create mysqlnet

docker run -it --rm  -v mysql_data:/var/lib/mysql -v mysql_config:/etc/mysql/conf.d --network mysqlnet --name mysqlserver -e MYSQL_USER=user -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=chess -p 3307:3306 mysql:8.0
docker run --rm --name springboot-server --network mysqlnet -e MYSQL_URL=jdbc:mysql://mysqlserver/chess -p 8080:8080 java-docker