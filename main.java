package myFirstList;

public class main {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>() ;
		list.addLast(25);
		list.addLast(16);
		list.addLast(0);
		list.addLast(28);
		list.addLast(10);
		list.addLast(39);
		list.addLast(7);
		list.print();
		
		System.out.println("\n============");
		
		list.bubbleSort();
		list.print();
		
		
	}

}
