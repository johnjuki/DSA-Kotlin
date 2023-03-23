# Data structures and algorithms

- Understand what an algorithm is and the importance of it in computer science.

## Kotlin Standard Library

Transformational functions: **let** & **run**

Mutating functions: **also** & **apply**

### List
- A general-purpose, generic container for storing an ordered collection of elements.

**Random-access**
- takes constant-time.

**Insertion location**
- add() - is a constant-time operation.
- insertion at anywhere besides the end will be a performance issue. e.g., insertion at the front, every element must shift back by one index.

### Map
- A generic collection that holds **key-value** pairs.
- A map uses hashCode() function to store the data.
- Maps are unordered, so you can't guarantee where new elements are put.
This is because maps put data into different *buckets*, depending on the result of the hashcode.
The data in each bucket is ordered, bu the general order of the data in the map is unpredictable.
- Inserting into a map is a constant-time operation.

# Complexity analysis

An algorithm becomes more powerful when used with proper data structures.

Algorithm - Steps to solve a problem.

It is something that takes a value or set of values as input, processes it, and returns  a value or a set of values as output.

Algorithms are a solution to a well-defined computational problem.

**NB** There's no single definition available for algorithms. We just have a few rules to categorize something as an algorithm. As long as your program satisfies those, we can argue that
it's an algorithm.

**Any program (whether simple or complex), if that consumes some input to calculate and gives some output can be called as an algorithm**

- For algorithms, scalability refers to how flexible your app is as your features are increasing.

An algorithm in analysed based on time complexity and space complexity.

**Profilers** measure the time & memory consumed by an algorithm.

**Time complexity** is a measure of the time required to run an algorithm as the input size increases.
It quantifies the time taken by the algorithm; in other words, we can define time complexity as the performance of an algorithm.

**Space complexity** of an algorithm defines the space (memory) consumed by it to produce the output for a given input.

By analyzing the complexity of any algorithm, we usually get answers to the following questions:
- How much time does it take to generate or calculate the output?
- How much memory does it need to solve the problem?
- How does it behave when the input size grows?
- Does it get faster or slower? If slower, how much slower? Does it get four times slower for two times the input size?
- What relationship does the time have with respect to the input size?

The complexity of an algorithm can broadly fall into the following three categories:
- Best case analysis: Best case defines the minimum time required by
an algorithm to produce the output. It's also represented as Omega
notation (Ω).
- Average case analysis: Average case defines the average time required
by an algorithm to produce the output for different sized input. It's also
represented as Theta notation (θ).
- Worst case analysis: Worst case defines the maximum time required
by an algorithm to produce the output. It's also represented as a Big O
notation (O).

## TIme Complexity

- It's a measure of the time required to run an algorithm as the input size increases.

**Constant Time - O(1)**
- A constant time algorithm is one that has the same running time regardless of the size of the input.

**Linear Time - O(n)**
- As the input size increases, the running time increases by the same amount.

**Quadratic Time - O(n^2)**
- This time complexity refers to an algorithm that takes time proportional to the square of the input size.

**Logarithmic time - O(log n)**
- An algorithm that repeatedly drop half of the required comparisons will have logarithmic time complexity.

**Quasilinear time - O(n log n)**
- Algorithms in this category perform worse than linear but dramatically better than quadratic time.
- is a multiplication of linear and logarithmic time.

**Others:**

**Polynomial time**, **Exponential time**, **Factorial time**

