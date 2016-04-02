javac -d "classes" base/*.java
javac -d "classes" -cp "classes" undirected/*.java
javac -d "classes" -cp "classes" directed/*.java
javac -d "classes" -cp "classes" tester/*.java
javac -d "classes" -cp "classes" algorithms/*.java

pause 10000