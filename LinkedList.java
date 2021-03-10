package myLinkedList;

public class LinkedList<T> {
	
	class Node<T> {
		T data;
		Node next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Node head = null;
	public Node tail = null;
	
	public void addNode(T data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void insertAtFirst(T data) {
		Node newNode1 = new Node(data);
		if(head == null) {
			head = newNode1;
			tail = newNode1;
		}
		else {
			Node node1 = head;
			head = newNode1;
			head.next = node1;
		}
	}
	
	public void insertAtLast(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void show() {
		Node current = head;
		
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		System.out.println("Values in list are : ");
		while(current != null) {
			System.out.println(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtLast(56);
		list.insertAtLast(30);
		list.insertAtLast(70);
		list.show();
	}
}
