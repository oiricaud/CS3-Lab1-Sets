The University of Texas at El Paso College of Engineering Dept. of Computer Science

CS 2302 : Data Structures 

LAB 1 Summer 2016 Deadline: Wednesday, June 15th, 11:59pm

Description: Naively a set is only a collection of objects, but even in this level of generality we can make sense of operations on sets, as arithmetical operations on integers, so we define

• (Intersection)A∩B={x|x∈Aandx∈B} • (Union)A∪B={x|x∈Aorx∈B}

• (Difference)A\B={x|x∈Abutx̸∈B}

• (Power) P(A) = {x|x ⊂ A}

whenever A and B are sets. For example, if we assign A = {1,2,3} and B = {2,3,4} then

• A∩B={2,3}

• A∪B={1,2,3,4}

• A \ B = {1}

• P(A)={∅,{1},{2},{3},{1,2},{1,3},{2,3},A}.

Problem: Create a class named Set that implements all the above set operations along with an appropriate toString() method. Even though, repetition of an element within a set is irrelevant, avoid including an element in a set more than once. Write a report describing your work.
Data Structures

