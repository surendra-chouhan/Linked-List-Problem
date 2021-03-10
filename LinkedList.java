package myLinkedList;

public class LinkedList {
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Node head = null;
	public Node tail = null;
	
	public void addNode(int data) {
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
	
	public void insertAtFirst(int data) {
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
		list.insertAtFirst(70);
		list.insertAtFirst(30);
		list.insertAtFirst(56);
		list.show();
	}
}
