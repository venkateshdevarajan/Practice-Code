package Old.LinkedList;

class LinkedListOps {
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