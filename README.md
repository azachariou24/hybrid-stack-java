<div align="center">

# Hybrid Stack in Java

### Generic Hybrid Stack implementation and stack-based algorithms

**Java • Data Structures • Algorithms • Generics**

</div>

---

## Overview

This repository provides a generic implementation of a **Hybrid Stack** in Java together with several stack-based algorithms.

The implementation combines the advantages of linked structures and fixed-size arrays by representing the stack as a linked list of array blocks. This hybrid approach reduces pointer overhead while maintaining dynamic growth.

The project was developed as part of my study of **Data Structures and Algorithms**, with emphasis on algorithmic correctness, clean object-oriented design, and code readability.

---

## Features

- Generic implementation using **Java Generics**
- Hybrid stack architecture (linked list of fixed-size arrays)
- Constant-time push and pop operations (amortized)
- Clean object-oriented design
- Stack visualization
- Demonstration program
- Stack-based algorithmic applications

---

## Complexity Analysis

- **push()** → **O(1)** (amortized)
- **pop()** → **O(1)** (amortized)
- **top()** → **O(1)**
- **isEmpty()** → **O(1)**
- **display()** → **O(n)**

---

## Implemented Algorithms

### Remove Minimum (Using Queue)

Finds and removes all occurrences of the minimum element using only stack operations together with a helper queue.

### Remove Minimum (Using Stack)

Finds and removes all occurrences of the minimum element using only stack operations together with a helper stack.

### Compress

Compresses consecutive equal values into *(frequency, value)* pairs while preserving the original order of the stack.

---

## Project Structure

```text
src/
└── datastructures/
    └── stack/
        ├── HybridStack.java
        ├── CircularQueue.java
        ├── StackAlgorithms.java
        └── Main.java
```

---

## Running the Project

Compile

```bash
javac src/datastructures/stack/*.java
```

Run

```bash
java -cp src datastructures.stack.Main
```

---

## Educational Objectives

This project demonstrates:

- Generic programming in Java
- Implementation of Abstract Data Types (ADTs)
- Hybrid memory organization
- Stack-based algorithmic techniques
- Algorithm complexity analysis
- Object-oriented software design

---

## Future Improvements

Potential future extensions include:

- Dynamic block resizing
- Iterator support
- JUnit test suite
- Javadoc documentation
- Additional stack-based algorithms
- Performance benchmarking
- Maven/Gradle support

---

## License

This project is licensed under the **MIT License**.

---

<div align="center">

**Developed by Anastasis Zachariou**

</div>