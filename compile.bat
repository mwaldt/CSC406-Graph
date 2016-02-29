javac -d "classes" base/*.java
javac -d "classes/graph/" -cp "classes" undirected/*.java
javac -d "classes/graph/" -cp "classes" directed/*.java
javac -d "classes/graph/" -cp "classes" tester/*.java

pause 10000