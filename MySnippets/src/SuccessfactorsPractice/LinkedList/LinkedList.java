package LinkedList;

public class LinkedList {
	
	private Node head = null;
	
	public void append (int n){
		Node lastNode = navigateToLastNode();
		Node newNode = new Node(n);
		if(lastNode == null){
			head = newNode;
		}
		else{
			lastNode.next = newNode;
		}		
	}
	
	public Node navigateToLastNode(){
		if(head == null){
			return null;
		}
		else{
			Node tempNode = head ;
			while(tempNode.next != null){
				tempNode = tempNode.next;
			}
			return tempNode;
		}
	}
	
	public void displayList(){
		if(head == null){
			System.out.println("List is Empty");
		}
		else{
			Node tempNode = head;
			while(tempNode!=null){
				System.out.print(tempNode.data + " --> ");
				tempNode = tempNode.next;
			}
		}	
		System.out.println();
	}
	
	public void delete(int n){		
		if(head == null){
			System.out.println("List is already empty");
		}
		else{
			Node previous = null;
			Node currentNode = head ;
			while(currentNode != null && currentNode.data != n){
				previous = currentNode;
				currentNode = currentNode.next;
			}
			
			if(currentNode == null){
				System.out.println("Number is not in list");
			}			
			else if(previous == null){
				head = head.next;
			}
			else {
				previous.next = currentNode.next;
			}
		}
	}
	
	public void reverse(){
		if(head == null || head.next == null){
			return;
		}
		else{
			Node previous = null;
			Node current = head;
			Node nextn;
			while(current!= null){
				nextn = current.next;
				current.next = previous;
				previous= current;
				current = nextn;
			}
			head = previous;
		}
	}
}

class LinkedListOps{
	public static void main(String[] args){
		LinkedList myList = new LinkedList();
		myList.displayList();
		myList.append(1);
		myList.append(2);
		myList.append(3);
		myList.append(4);
		myList.append(5);
		myList.append(6);
		myList.append(7);
		myList.displayList();
		myList.delete(1);
		myList.displayList();
		myList.delete(7);
		myList.displayList();
		myList.delete(5);
		myList.displayList();
		myList.append(8);
		myList.displayList();
		myList.reverse();
		myList.displayList();
		myList.reverse();
		myList.displayList();
		
	}
}