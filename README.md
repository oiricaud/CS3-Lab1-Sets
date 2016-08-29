//Author: Oscar Ivan Ricaud.
//Assignment: Lab 1
//Program purpose: this program calls the following, union, intersection, difference, and powerSet1 and powerSet2. The difference between the powerSet1 is that I was not able to successfully delete the 
// duplicate elements. So I wanted to try a different approach, using a Node class. I use this node class to create my set to obtain multiple pointers of the head. Although
// the list only works up to n = 3 due to some troubloshooting in my recursive calls. This is something I need to fix in the future. 

// <--- Set Operation Definitions -- > 
// A set is a collection of objects where redundent objects are not counted twice.
// Union - There exists an element x such that the element x is in Set A or Set B. 
// Intersection - There exists an element x such that the element is in Set A and also in Set B. 
// Difference - For all x in set A but not in Set B.
// PowerSet - the subsets of the set including the power set.

// More details on the upcoming report....

// <-- How to operate lab1sets.java -->
	// I will assume the user knows what the basic definitions of a set so it wont be necessary for Try and Catch errors such as the user mistakenly entering {1,1}. 
	// To modify the sets A and Set B simply look for the "Modify sets here" bar. Perhaps in the future I can modify the piece of code to receive multiple sets such 
	// Set A, Set B, Set C, ... Set Z.
	// After you modify the input in the sets the computer will simply run the many for loops and give the correct output.

// <----Some nasty bugs ----->
	// For powerSet1 there are multiple repeats of the set, modify code to delete redenduent permuations. 
	
//Instructor: Professor Julio Urenda
//TA Saiful Abu
//Course 2302
//Data of Last modification June 15th, 2016.
