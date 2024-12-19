# Variables
JAVAC = javac
JAVA = java
SRC = Main.java
TARGET = Main

# Default target: Build and run the program
all: build run

# Compile the Java file
build:
	@$(JAVAC) $(SRC)

# Run the compiled program
run:
	@$(JAVA) $(TARGET)

# Clean up the .class files
clean:
	@rm -f *.class

