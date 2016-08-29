package labs;

public class Node {
	int cargo; 
	Node next; 

	public Node () { 
		cargo = 0; 
		next = null; 
	} 

	public Node (Object cargo, Node next) { 
		this.cargo = (Integer) cargo; 
		this.next = next; 
	} 

	public String toString () { 
		return cargo + ""; 
	} 
	public static void printList(Node x){
		if (x!= null){
			System.out.print(x.cargo+" ");
			printList(x.next);
		}
	} 
}

