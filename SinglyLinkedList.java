package myFirstList;


//instance variables of the SinglyLinkedList
public class SinglyLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private Node<E> curr; 
	private int size; 

	public SinglyLinkedList() {

		head = null;
		tail = null;
		curr = null;
		size = 0;
	}
	// Remove all elements

	public void clear() {
		head = tail = null;
		size = 0;
	}
	// access methods

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() { // returns (but does not remove) the first element
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	public E last() { // returns (but does not remove) the last element
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	// update methods
	public void addFirst(E e) { // adds element e to the front of the list
		head = new Node<>(e, head); // create and link a new node
		if (size == 0) {
			tail = head; // special case: new node becomes tail also
		}
		size++;
	}

	public void addLast(E e) { // adds element e to the end of the list
		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty()) {
			head = newest; // special case: previously empty list
		} else {
			tail.setNext(newest); // new node after existing tail
		}
		tail = newest; // new node becomes the tail
		size++;
	}

	public void isFound(E e) {
		Node<E> curr = head ;

		while (curr != null) {
			if (curr.getElement() == e) {
				System.out.println("Found");
				return ;
			}
			curr=curr.getNext() ;
		}
		System.out.println("not found");


	}

	public E removeFirst() { // removes and returns the first element
		if (isEmpty()) {
			return null; // nothing to remove
		}
		E answer = head.getElement();
		head = head.getNext(); // will become null if list had only one node
		size--;
		if (size == 0) {
			tail = null; // special case as list is now empty
		}
		return answer;
	}

	public E removeLast() {

		if(isEmpty()) {
			return null;
		}

		E ansewr = tail.getElement() ;

		if(head == tail) {
			head=tail = null ;
		}else {
			curr = head ;
			while (curr.getElement() != tail) {
				curr = curr.getNext() ;
			}
			tail = curr ;
			tail.setNext(null);		 
		}	 
		size-- ;
		return ansewr ;

	}

	// Add
	public void add(E element, int index) {
		if (index < 0 || index > size) {
			System.out.println("Out of bound!");
			return;
		}
		Node<E> newest = new Node<E>(element, null);
		if (index == 0) // add at front
		{
			newest.setNext(head);
			head = newest;
			if (tail == null) {
				tail = head;
			}
		} else // add the middle
		{
			curr = head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.getNext();
			}
			newest.setNext(curr.getNext());
			curr.setNext(newest);
			if (tail == curr) {
				tail = tail.getNext();
			}
		}
		size++;
	}

	// removing node at index i
	public E remove(int index) {// O(n)
		if (index < 0 || index >= size) {
			System.out.println("Out of bound!");
			return null;
		}
		E element;
		if (index == 0) // remove from front
		{
			element = head.getElement();
			head = head.getNext();
			if (head == null) {
				tail = null;
			}
		} else {
			curr = head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.getNext();
			}
			element = curr.getNext().getElement();
			if (tail == curr.getNext()) {
				tail = curr;
			}
			curr.setNext(curr.getNext().getNext());
		}

		size--;
		return element;
	}

	//
	public void moveToStart() {
		curr = head;
	}

	public void moveToEnd() {
		curr = tail;
	}

	public void next() {
		if (curr != tail) {
			curr = curr.getNext();
		}
	}

	public E getValue() {
		return curr.getElement();
	}

	// return the postion of current element
	public int CurrPos() {
		Node<E> temp = head;
		int i = 0;
		while (temp != curr) {
			temp = temp.getNext();
			i++;
		}
		return i;
	}

	// move curr to postion
	public void moveToPos(int pos) {
		if (pos < 0 || pos >= size) {
			System.out.println("Position out of range!");
		} else {
			curr = head;
			for (int i = 0; i < pos; i++) {
				curr = curr.getNext();
			}
		}
	}
	public E getElementPos(int pos) {

		if(pos < 0 || pos >= size) {
			System.out.println("Out of bound");
		}
		curr = head ;
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext() ;
		}
		return curr.getElement() ;
	}

	public void print() {
		if(head==null) {
			return;
		}

		curr = head;
		while (curr != null) {
			System.out.print(curr.getElement()+" ");
			curr = curr.getNext();
		}
	}
	public void swap(int x , int y) {

		if(head == null || head.getNext() == null)
			return ;

		Node<E>temp1 = head ;
		Node<E>temp2 = head ;

		while ((Integer)temp1.getNext().getElement() != x) {
			temp1 = temp1.getNext() ;
		}
		while ((Integer)temp2.getNext().getElement() != y) {
			temp2 = temp2.getNext() ;
		}
		Node p1 = temp1.getNext() ;
		Node p2 = temp2.getNext() ;


		temp1.setNext(p1.getNext());
		temp2.setNext(p2.getNext());

		p2.setNext(temp1.getNext());
		temp1.setNext(p2);

		p1.setNext(temp2.getNext());
		temp2.setNext(p1); 

	}
	public void removeSecond() {

		if(size < 2)
			System.out.println("not Enough values!!");
		else {
			head.setNext(head.getNext().getNext());
			size-- ;

			if(size==1)
				tail=head ;
		}



	}
	public void ExchangeFL() {

		if(head == null || head.getNext()==null)
			return ;

		Node F =head ;
		Node L =tail ;

		if(size == 2) {
			tail.setNext(F);
			tail = tail.getNext() ;
			head = head.getNext() ;
		}else {
			head= head.getNext() ;
			Node curr = head ; 
			while (curr.getNext() != tail) {
				curr = curr.getNext() ;
			}
			tail = curr ;

			L.setNext(head);
			head =L ;

			F.setNext(null);
			tail.setNext(F);
			tail = tail.getNext();
		}


	}
	//This method split the given list into two new lists one for odd number other for even
	public void splitOddEven(SinglyLinkedList list1 , SinglyLinkedList list2) {

		if(head == null || head.getNext()==null)
			return ;


		curr = head ;
		while (curr != null) {
			if((Integer)curr.getElement() % 2 == 0) {
				list2.addLast(curr.getElement());	
			}else {
				list1.addLast(curr.getElement());
			}
			curr = curr.getNext() ;		
		}
	}


	
	// this method make the list ascending order 1, 2, 3, 0, 5, 6 --> 1, 2, 3, 4, 5, 6
	public void forceAscendingOrder(SinglyLinkedList list) {

		if(isEmpty()) 
			return ;

		curr = head  ;

		while (curr.getNext() != null) {
			if((Integer)curr.getNext().getElement() < (Integer)curr.getElement()) {
				curr.setNext(curr.getNext().getNext());
			}else {
				curr = curr.getNext() ;
			}

		}

	}
	//return the middle value in the list
	public E middel() {

		if(isEmpty())
			return null;
		Node ref ;
		Node temp = head ;
		int num = size/2 ;

		for (int i = 0; i < num; i++) {
			temp = temp.getNext() ;
		}
		if(this.size % 2 == 0) {
			ref = temp.getNext() ;
			return (E) ref.getElement() ;
		}else {
			temp= temp.getNext() ;
			return (E) temp.getElement() ;
		}
	}
	
	//this method return the total of max number and odd
	public int sumMaxMin(SinglyLinkedList list) {

		if(isEmpty())
			return 0;
		int min ,max ;
		min=max=(Integer)head.getElement() ;
		curr = head ;
		while (curr != null) {
			if((Integer)curr.getElement() < min)
				min = (Integer)curr.getElement() ;
			if((Integer)curr.getElement() > max)
				max = (Integer)curr.getElement() ;
			curr = curr.getNext() ;	
		}
		return max+min ;
	}
	//this method deleted the odd number on the list
	public void RemoveOdd() {
		Node temp = head ;

		if(isEmpty())
			return ; 

		if(head.getNext() == null && (Integer)head.getElement()%1 == 1) {
			head=tail=null ;
			size= 0 ;
			return ;
		}
		while (temp.getNext() != null ) {
			if((Integer)temp.getNext().getElement() %2 == 1) {
				temp.setNext(temp.getNext().getNext());
				size--;
			}else {
				temp= temp.getNext() ;
			}		
		}
		if((Integer)head.getElement()%2 == 1) {
			head = head.getNext() ;
			size-- ;
		}
	}
	//this method Duplicate value on the list
	public void DublicateValue(int x) {

		if(isEmpty())
			return ;

		curr = head ;
		Node elem =new Node(x, null);
		while (curr != null) {
			if((Integer)curr.getElement() == x) {
				elem.setNext(curr.getNext());
				curr.setNext(elem);
				if(tail ==curr)
					tail = elem ;
				curr = curr.getNext().getNext() ;

			}else {
				curr = curr.getNext();
			}
		}
		size++;
	}
	
	public SinglyLinkedList mergedNum(SinglyLinkedList list) {
		if(list.head == null || list.head.getNext()==null)
			return null;

		SinglyLinkedList elem = new SinglyLinkedList<>() ;
		Node curr = list.head ;
		while (curr != null && curr.getNext() != null) {
			elem.addLast((int)curr.getElement() + (int)curr.getNext().getElement());
			curr = curr.getNext().getNext() ;
		}
		if(list.size %2 == 1)
			elem.addLast(curr.getElement());
		return elem ;
		
	}
	
	public void split(SinglyLinkedList list ,SinglyLinkedList list1 , SinglyLinkedList list2 ) {
		
		if(list.head == null && list.head.getNext() == null)
			return ;
		
		int value = (int)head.getElement() ;
		
		curr = list.head ;
		
		while (curr != null) {
			
			if((int)curr.getElement() == value)
				list1.addLast(curr.getElement());
			else
				list2.addLast(curr.getElement());
			curr = curr.getNext() ;
		}
		
	}
	
	public void addAfterMin(int value) {
		if(isEmpty())
			return ;
		
		Node newest = new Node (value, null);
		int min = (int)head.getElement() ;
		curr = head ;
		while (curr != null) {
			if((int)curr.getElement() < min)
				min = (int)curr.getElement() ;
			curr = curr.getNext() ;
		}
		curr = head ;
		while ((int)curr.getElement() != min) {
			curr = curr.getNext() ;
		}
		newest.setNext(curr.getNext());
		curr.setNext(newest);
		
		if(tail == curr)
			tail = tail.getNext() ;
		
		
		
	}
	public SinglyLinkedList MaxElementAtPos(SinglyLinkedList list1, SinglyLinkedList list2) {
		
		if(list1.head == null || list2.head == null)
			return null ;
		
		SinglyLinkedList list = new SinglyLinkedList () ;
		
		int number = 0 ;
		Node curr1 = list1.head ;
		Node curr2 = list2.head ;
		
		while (curr1!=null&&curr2!=null) {
			if((int)curr1.getElement() > (int)curr2.getElement())
				number = (int)curr1.getElement() ;
			else
				number = (int)curr2.getElement() ;
			
			if(list.head == null) {
				list.head=list.tail = new Node (number, null) ;
			}else {
				list.tail.setNext(new Node (number, null));
				list.tail = list.tail.getNext() ;
			}
			
			curr1 = curr1.getNext() ;
			curr2 = curr2.getNext() ;
			
			
		}
		
		
		return list ;
		
	}
	public void DeleteLargest() {
		if(isEmpty())
			return  ;
		
		if(head == tail)
			return ;
		
		int max = 0;
		Node curr = head ;
		while (curr != null) {
			if((int)curr.getElement() > max)
				max= (int)curr.getElement() ;
			curr = curr.getNext() ;
		}
		curr = head ;
		while ((int)curr.getNext().getElement() != max) {
			curr = curr.getNext() ;
		}
		curr.setNext(curr.getNext().getNext());
		
	}
	
	public void removeDublicat() {
		if(isEmpty() && head == tail)
			return ;
		
		Node curr = head ;
		while (curr.getNext() != null) {
			if(curr.getElement() == curr.getNext().getElement())
				curr.setNext(curr.getNext().getNext());
			else 
				curr = curr.getNext();
			
		}
	}
	public void ExchangeF() {
		
		if(isEmpty() || size < 2)
			return  ;
		
		Node Fist = head ;
		Node last = tail ;
		Node curr = head ;
		
		if(size == 2) {
			tail.setNext(Fist);
			tail = tail.getNext() ;
			head = head.getNext() ;
		}else {
			while (curr.getNext() != tail) {
				curr = curr.getNext() ;
			}
			tail = curr ;
			last.setNext(head);
			head = last ;
			tail.setNext(null);
			tail =tail.getNext() ;
		}
	}
	
	public void insertAfterElement(int val , int key) {
		
		if(isEmpty())
			return  ;
		
		Node curr = head ;
		Node newest = new Node(val, null) ;
		
		while ((int)curr.getElement() != key) {
			curr= curr.getNext() ;
		}
		newest.setNext(curr.getNext());
		curr.setNext(newest);
	}
	public void forceAscenndingOrder() {
		if(isEmpty())
			return ;
		
		Node curr = head ;
		
		int index = 0 ;
		while (curr.getNext() != null) {
			if((int)curr.getNext().getElement() <(int)curr.getElement() ) {
				curr.setNext(curr.getNext().getNext());
			}else
				curr = curr.getNext() ;
		}
	}
	public int MidSingleList() {
		if(isEmpty())
			return 0;
		
		int x = size/2 ;
		Node curr = head ;
		if(size % 2 == 0) {
			for (int i = 1; i < x; i++) {
				curr = curr.getNext() ;
			}
		}else {
			for (int i = 1; i < x+1; i++) {
				curr = curr.getNext() ;
			}
		}
		return (int)curr.getElement() ;
	}
	public void RemoveOdds() {
		if(isEmpty())
			return ;
		
		
		if((int)head.getElement() % 2 == 1) 
			head = head.getNext() ;
			
		Node curr = head ;
		while (curr.getNext() != tail) {
			if((int)curr.getElement() % 2 ==1)
				curr.setNext(curr.getNext().getNext());
			curr = curr.getNext() ;
		}
	}
	public SinglyLinkedList MargeSum() {
		
		if(isEmpty() || size >= 1 )
			return null;
		SinglyLinkedList<Integer> temp = new SinglyLinkedList<>() ;
		
		int x = size/2 ;
		
		Node curr = head ;
		if(size %2 == 0) {
			for (int i = 0; i < x; i++) {
				temp.addLast((int)curr.getElement()+(int)curr.getNext().getElement());
				curr = curr.getNext().getNext() ;
			}
			
		}else {
			for (int i = 0; i < x; i++) {
				temp.addLast((int)curr.getElement()+(int)curr.getNext().getElement());
				curr = curr.getNext().getNext() ;
			}
			temp.addLast((int)tail.getElement());
		}
		return temp ;
	}
	public void bubbleSort() {
		
		Node curr = head ;
		
		for (int i = 0; i < size-1; i++) {
			 curr = head ;
			 for (int j = 0; j < size-1; j++) {
				if((int)curr.getElement() > (int)curr.getNext().getElement()) {
					int temp = (int)curr.getNext().getElement() ;
					curr.getNext().setElement(curr.getElement());
					curr.setElement(temp);
				}
				curr = curr.getNext() ;
			}
		}
	}
}