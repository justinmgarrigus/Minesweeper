pre-build:
ifeq ("$(wildcard class)", "")
	mkdir class
endif 

java: pre-build 
	javac -cp .;lib/system-hook-3.8.jar -d class src/Minesweeper.java
	java -cp .;lib/system-hook-3.8.jar;class Minesweeper