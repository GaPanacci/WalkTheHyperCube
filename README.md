# Hypercube Walk

This Java program is designed to explore and output the sequence of corners visited along a walk of an n-dimensional hypercube. It features both recursive and iterative approaches to solving the problem, catering to different computational models and preferences.

## Features

- **Dimension Setting:** Users can input the dimension of the hypercube they wish to explore, with the program ensuring the dimension is within a specified range (between 3 and 5 inclusive).
- **Recursive Walk:** Utilizes a recursive strategy to traverse the hypercube, outputting each corner's sequence as visited.
- **Iterative Walk:** An alternative to the recursive approach, this method iteratively traverses the hypercube, also outputting the sequence of corners visited.
- **Gray Code Conversion:** Both traversal methods include a step to convert the binary representation of the hypercube's corners to Gray code, a binary numeral system where two successive values differ in only one bit.

## Usage

1. **Set Hypercube Dimension:** Upon execution, the program prompts the user to enter the desired dimension of the hypercube. This dimension must be between 3 and 5, inclusive.
2. **Recursive Walk:** After setting the dimension, the program first performs a recursive walk of the hypercube, printing out the sequence of corners visited in Gray code.
3. **Iterative Walk:** Following the recursive walk, an iterative walk is performed, with the sequence of corners visited similarly printed out in Gray code.

## How It Works

- The program starts by asking the user for the dimension of the hypercube to be explored.
- For the recursive walk:
    - The program dives deeper into the dimensions of the hypercube, adding 0s and 1s to represent moving through dimensions.
    - A helper method is used to convert the binary path to Gray code before outputting each sequence of corners visited.
- For the iterative walk:
    - The program iterates over all possible binary numbers for the given dimension, treating each as a path through the hypercube.
    - Each path is converted to Gray code before being outputted.
- The Gray code conversion is essential for both methods to ensure that each step moves to an adjacent corner of the hypercube.

## Implementation Details

- The program ensures that user input is within the allowed range to prevent errors during the walk.
- Uses a dynamic data structure (`ArrayDeque<Integer>`) to efficiently manage the current state and path through the hypercube.
- Implements two separate helper methods for the recursive and iterative walks to convert the binary representation of the hypercube's corners to Gray code.

## Running the Program

To run this program:

1. Compile the Java code using a Java compiler (e.g., `javac Hypercube.java`).
2. Run the compiled class file with Java Runtime Environment (e.g., `java Hypercube`).
3. Follow the on-screen prompts to input the hypercube dimension and then view the sequences of corners visited in both recursive and iterative walks.

This program provides a clear demonstration of different algorithmic approaches (recursive and iterative) to exploring complex structures like hypercubes and the application of Gray code in computational problems.

