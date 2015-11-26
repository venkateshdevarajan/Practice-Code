package Algos;

import LinkedList.LinkedList;
import LinkedList.Node;

public class Amazon2 {
	
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
	
	public static void findCommonNodes(Amazon2 myList, Amazon2 myList1){
		Node temp = myList.head;
		Node temp1 = myList1.head;
		int count = 0;
		int max = 0;
		
		while(temp != null || temp1 != null){			
				int data = temp.data;
				if(temp1.data == data ){
					count ++;
					temp = temp.next;
					temp1 = temp1.next;
				}
				else{
					max = count;
					count =0 ;
					temp1 = temp1.next;
				}			
		}
		System.out.println(max);		
	}
	
	public static void main(String[] args){
		Amazon2 myList = new Amazon2();
		
		myList.append(1);
		myList.append(2);
		myList.append(3);
		myList.append(4);
		myList.append(5);
		myList.append(6);
		
		Amazon2 myList1 = new Amazon2();		
		myList1.append(1);
		myList1.append(2);
		myList1.append(3);
		myList1.append(9);
		myList1.append(8);
		myList1.append(7);
		
		myList.displayList();
		System.out.println();
		myList1.displayList();
		
		findCommonNodes(myList, myList1);
	}

}
