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
- insertion at anywhere besides the end will be a performance issue. e.g., insertion at the front, every element must
  shift back by one index.

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

It is something that takes a value or set of values as input, processes it, and returns a value or a set of values as
output.

Algorithms are a solution to a well-defined computational problem.

**NB** There's no single definition available for algorithms. We just have a few rules to categorize something as an
algorithm. As long as your program satisfies those, we can argue that
it's an algorithm.

**Any program (whether simple or complex), if that consumes some input to calculate and gives some output can be called
as an algorithm**

- For algorithms, scalability refers to how flexible your app is as your features are increasing.

An algorithm in analysed based on time complexity and space complexity.

**Profilers** measure the time & memory consumed by an algorithm.

**Time complexity** is a measure of the time required to run an algorithm as the input size increases.
It quantifies the time taken by the algorithm; in other words, we can define time complexity as the performance of an
algorithm.

**Space complexity** is a measure of the resources required for the algorithm to manipulate the input data.

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

# Linked List

***By the end you should know:***

1. how to implement a linked list.
2. the common operations associated with a linked list.
3. the time complexity of each operation.

- A linked list is a collection of values arranged in a linear, unidirectional sequence.

## Operations

1. push - **O(1)** : Adds a value at the front of the list.
2. append - **O(1)** : Adds a value at the end of the list.
3. insert - **O(1)** : Adds a value after a particular node of the list.
4. pop - **O(1)** : Removes the value at the front of the list.
5. remoteLast - **O(n)** : Removes the value at the end of the list.
6. removeAfter - **O(1)** : Removes a value after a particular node of the list.

### Kotlin collection interfaces

- **Tier 1, Iterable**: An iterable type provides sequential access to its elements via an
  Iterator.
- **Tier 2, Collection**: A collection is an iterable that provides additional
  functionality, allowing you to check if the collection contains a particular element
  or a collection of elements.
- **Tier 3, MutableIterable**: An iterable that provides a _MutableIterator_, which
  allows both accessing the items and removing them.
- **Tier 4, MutableCollection**: A collection that also provides methods to alter its
  contained items. For example, you can **add** and **remove** elements, and even **clear**
  the entire collection.

A linked list goes all the way to **MutableCollection** interface.

The **runner technique** helps solve a variety of problems associated with the linked list.

# Stack Data Structures

- The main goal of building a stack is to enforce how you access your data.

## Operations

1. **Push - O(1)**: Adding an element on top of the stack.
2. **Pop - O(1)**: Removing the top element of the stack.

- This means that you can only add or remove elements from one side of the data structure.
- A stack is known as the LIFO (last-in-first-out) data structure.
- Stacks are crucial to problems that _search_ trees and graphs.

# Queues

***By the end you should know:***

1. how to implement a queue
2. the common operations associated of a queue.
3. the time complexity of each operation.

- Queues use **FIFO** or **first in, first out** ordering, meaning the first element that was added
  will always be the first one removed.
- Queues are handy when you need to maintain the order of your elements to process later.

## Operations

- enqueue: Inserts an element at the back of the queue and returns true if the operation is successful.
- dequeue: Removes the element at the front of the queue and returns it.
- isEmpty: Checks if the queue is empty using the count property.
- peek: Returns the element at the front of the queue without removing it.

Notice that the queue only cares about removal from the front and insertion at the
back. You don’t need to know what the contents are in between. If you did, you’d
presumably use an array instead of a Queue.

You can create stacks using:

- an array based list
- a doubly linked list
- a ring buffer
- two stacks

### Ring buffer implementation

- A ring buffer, also known as a circular buffer, is a fixed-size array.
- This data structure wraps around to the beginning when there are no more items to remove at the end.

### Double stack implementation

- leveraging this data structure improved dequeue() time complexity to an amortized O(1) operation.
- this implementation beats linked list in terms of spatial locality.

# Trees

- Trees are a useful way to organize information where performance is critical.
- it introduces the concept of children and parents.
- used to tackle many recurring challenges in software development, such as:
    1. Representing hierarchical relationships.
    2. Managing sorted data.
    3. Facilitating fast lookup operations.

Traversing trees?

There are multiple strategies for different trees and different problems.
In all of these ways you can **visit** the node and use the information into them.

## 1. Depth-first traversal

- Depth-first traversal starts at the root node and explores the tree as far as possible along each branch before
  reaching a leaf and then backtracking.
- Uses recursion to process the next node. Recursion is best used because is more simple an elegant to code.

## 2. Level-order traversal

- Level-order traversal is a technique that visits each node of the tree based on the depth of the nodes.
- Starting at the root, every node on a level is visited before going to a lower level.
- Here you use a **queue** to ensure that nodes are visited in the right level-order.

## Search

- In search, you get different objects depending on what traversal you use.


