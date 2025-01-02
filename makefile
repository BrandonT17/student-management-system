# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
TARGET = Main

# Default target: Build and run the program
all: build run

# Compile all Java files in the src directory
build:
	@mkdir -p $(BIN_DIR)                  # Ensure bin directory exists
	@$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/*.java  # Compile all .java files into bin directory

# Run the program
run:
	@$(JAVA) -cp $(BIN_DIR) $(TARGET)     # Run Main class from bin directory

# Clean up the bin directory
clean:
	@rm -rf $(BIN_DIR)                    # Remove the bin directory and its contents

