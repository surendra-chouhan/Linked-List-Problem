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
		list.addNode(56);
		list.addNode(30);
		list.addNode(70);
		list.show();
	}
}
