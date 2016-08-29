package labs;

import java.util.Arrays;
import java.util.LinkedList;

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

public class lab1Sets {
	public static void main(String[] args) {

		LinkedList<Object> setC = new LinkedList<Object>();
		LinkedList<Integer> setD = new LinkedList<Integer>();
		LinkedList<Integer> setE = new LinkedList<Integer>();
		LinkedList<Object> tempSet = new LinkedList<Object>();

		
		// <-------- MODIFY SETS HERE ---------> //
		int[] setA = {1,2,3};
		int[] setB = {1}; 
		// <-------- MODIFY SETS HERE ---------> //
		
		
		System.out.println("Set A contains: " + Arrays.toString(setA));
		System.out.println("Set B contains: " + Arrays.toString(setB));

		// <-- A U B --> BELOW
		LinkedList<Object> Union = union(setA, setB, setC);
		System.out.println("A union B = " + Union);

		// <-- A N B --> BELOW
		LinkedList<Integer> Intersection = intersection(setA, setB, setD);
		System.out.println("A intersection B = " + Intersection);

		// <-- A\B -->  all the elements in set A but not in set B. 
		LinkedList<Integer> Difference = difference(setA, setB, setE);
		System.out.println("A not in B = " + Difference);

		
		// <--- POWER SET USING LINKEDLIST BELOW --> // 
		//LinkedList<Object> PowerSet = powerSet(Union, tempSet);
		//	System.out.print("Length of PowerSet:  "+ PowerSet);
		// <!--> POWER SET USING LINKEDLIST  ABOVE --> //
		
		
		// <--- POWER SET USING NODES BELOW WORKS UP TO N = 3 --> // 
		Node node1 = new Node(1, null);
		Node node2 = new Node(2, null);
		Node node3 = new Node(3, null);

		node1.next = node2; 
		node2.next = node3;
		node3.next = null;

		
		
		
		Node jumper = new Node();
		LinkedList<Object> PowerSet2 = powerSet2(node1, jumper, tempSet, node1);
		System.out.print("powerSet2: "+ PowerSet2.toString()  + "");
	}

	private static LinkedList<Object> powerSet2 (Node currentNode, Node jumperNode,  LinkedList <Object> powerSetList, Node originalList) {

		if(currentNode == null) {
			powerSetList.add("{emptyset}");
			return null;
		}
		else{
			jumperNode = currentNode.next;

			while(jumperNode != null){


				powerSetList.add("{" + currentNode );
				powerSetList.add("" + jumperNode + "}");

				jumperNode = jumperNode.next;

			}

			//originalList.add("}");
			powerSetList.add("{" + currentNode + "}");
			currentNode = currentNode.next;
			powerSet2(currentNode, jumperNode, powerSetList, originalList);
		}
		return powerSetList;

	}
	
	// <--- POWER SET METHOD USING LINKED LIST BELOW. CREATE METHOD TO GET RID OF REPEATS --> // 
	
	private static LinkedList<Object> powerSet(LinkedList<Integer> setS, LinkedList<Object> tempSet) {
		LinkedList<Integer> newSetS = new LinkedList<Integer>();
		System.out.println("	SetS.length == " + setS.size());

		if(setS.size() == 0){
			//System.out.println("!!Set S = empty!!");
			tempSet.add(null);
			//return tempSet;
			//return copy;
		}
		else{
			if(!(newSetS.contains(setS))){
				
				for(int i = 0; i < setS.size(); i++){
					newSetS.add(setS.get(i));
					//System.out.println("67: newSetS: " + newSetS.get(i));
				}
				
				for(int j = 0 ; j < newSetS.size(); j++){
					System.out.println("What am I removing from the list? " + newSetS.remove(j));
					powerSet(newSetS, tempSet);
					newSetS.add(j, setS.get(j));
					System.out.println("newSetS.add(j, setS.get(j) " + newSetS.get(j));
				}
				
				tempSet.add("{" + newSetS + "}");
				//	System.out.println("new SetS size" +  newSetS.size() );
			}
		}	
		
		// <---------- DEBUGGING BELOW ------------->
		//	System.out.println("The tempset does not contains any elements from newSetS--> " + newSetS.get(i));
		//	System.out.println("		The tempSet --> " + newSetS.get(i));
		//	System.out.println("newSetS before calling method again = " + newSetS);
		//System.out.print("{" + newSetS  + "}, ");
		//System.out.print("{" + copy + "}, ");
		//	System.out.println("Remove repeats:--> " + copy);
		//System.out.println("Empty Set = {" + emptySet  + "}");
		//	System.out.println("copy= " + copy);
		//	System.out.print("copy --> {" + copy  + "}, ");
		// <---------- DEBUGGING ABOVE ------------->

		return tempSet;
	}


	
	
	// <--- DIFFERENCE SET METHOD USING LINKED LIST and ARRAYS --> //
	private static LinkedList<Integer> difference(int[] setA, int [] setB, LinkedList<Integer> setE) {

		LinkedList<Integer> setF = new LinkedList <Integer>() ;
		LinkedList<Integer> setG = new LinkedList <Integer>() ;
		LinkedList<Integer> setT = new LinkedList <Integer>() ;

		for(int i = 0 ; i < setA.length; i++){
			for(int j = 0 ; j < setB.length; j++){
				//for testing -->System.out.println("setA["+ i +"]= " + setA[i]);
				if(!(setF.contains(setA[i]))){
					setF.add(setA[i]);
				}
				if(!setG.contains(setB[j])){
					setG.add(setB[j]);
					//for testing -->System.out.println("setB["+ j +"]= " + setB[j]);
				}
				//for testing -->System.out.println("setB["+ j +"]= " + setB[j]);
				//for testing -->System.out.println("What is the value of isinOtherSet method? : " + isNotinOtherSet(setF.get(i), setB));
				if(setF.get(i) != (setG.get(j)) && isNotinOtherSet(setF.get(i), setB) == true && (!setT.contains(setF.get(i)))){
					//	setF.add(setF.get(i));
					setT.add(setF.get(i));
					
					// <------- DEBUGGING ----->
					//System.out.println("Value of i " + i);
					//System.out.println("here--> setF[" + i + "]= " + setF.get(i) + "its in location of setF: " + setF.indexOf(setF.get(i)));
					//	System.out.println("here--> setG[" + j + "]= " + setG.get(j) + "its in location of setG: "+ setG.indexOf(setG.get(j)));;
					//	System.out.println("");
					//setT.add(setF.get(i));
				}
			}
		}
		//for testing -->setF.remove();
		//for testing -->setF.remove(2);
		//for testing -->System.out.println("setF: " + setF.toString());
		//for testing -->setF.remove(2);
		//for testing -->setF.remove(1);
		return setT;
	}
	
	// <--- IS-NOT-IN-OTHER-SET/BOOLEAN METHOD RETURNS FALSE IF ELEMENS ARE IN BOTH SETS --> //
	private static boolean isNotinOtherSet(Integer element, int[] setB) {
		for(int i = 0; i < setB.length; i++){
			if(element==(setB[i])){
				return false;
			}
		}
		return true;
	}

	// <--- INTERSECTION SET METHOD USING LINKED LIST and ARRAYS --> //
	private static LinkedList<Integer> intersection(int[] setA, int[] setB, LinkedList<Integer> setD) {

		for(int i = 0; i < setA.length; i++){
			// for testing --> System.out.println("setA[" +i +"]=" + setA[i]);
			for(int j = 0; j< setB.length; j++){
				// for testing --> System.out.println("setB[" +j +"]=" + setB[j]);
				if(setA[i] == setB[j]){
					// for testing --> System.out.println("here A=" + setA[i] + ", B=" + setB[j]);
					if((!setD.contains(setA[i]))) {
						setD.add(setA[i]);
					}
					if((!setD.contains(setB[j]))){
						setD.add(setB[j]);
					}
					// for testing-->	=System.out.println("Both setA["+i+"] and setB[" + j+"]  are not the same there a");
				}
			}
		}
		return setD;
	}

	// <--- UNION SET METHOD USING LINKED LIST and ARRAYS --> //
	public static LinkedList<Object> union(int[] setA, int[] setB, LinkedList<Object> setC) {

		for(int i = 0; i < setA.length; i++){
			//	System.out.println("setA[" +i +"]");
			for(int j = 0; j< setB.length; j++){
				//	for testing---	System.out.println("setB[" +j +"]");
				if((!setC.contains(setA[i]))){
					setC.add(setA[i]);
				}
				if(!setC.contains(setB[j])){
					setC.add(setB[j]);
					// for testing--	=System.out.println("Both setA["+i+"] and setB[" + j+"]  are not the same there a");
				}
			}
		}
		return setC;
	}
}
