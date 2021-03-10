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
	
	public Node<T> head = null;
	public Node<T> tail = null;
	
	public void addNode(T data) {
		Node<T> newNode = new Node<T>(data);
		
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
		Node<T> newNode1 = new Node<T>(data);
		if(head == null) {
			head = newNode1;
			tail = newNode1;
		}
		else {
			Node<T> node1 = head;
			head = newNode1;
			head.next = node1;
		}
	}
	
	public void insertAtLast(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public Node<T> insertAtMiddle(T data, int position) {
		Node<T> newNode = new Node<T>(data);
		newNode.data = data;
		Node<T> current = head;
		Node<T> previous = null;
		int i = 0;
		while(i < position) {
			previous = current;
			current = current.next;
			i++;
		}
		newNode.next = current;
		
		if(previous != null) {
			previous.next = newNode;
			return head;
		}
		return newNode;
	}
	
	public void popFirstElement() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		else {
			if (head != tail) {
				head = head.next;
			}
			else {
				head = tail = null;
			}
		}
	}
	
	public void popLastElement() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		else {
			if (head != tail) {
				Node<T> current = head;
				while(current.next != tail) {
					current = current.next;
				}
				tail = current;
				tail.next = null;
			}
			else {
				head = tail = null;
			}
		}
	}
	
	public void searchNode(T data) {
		Node<T> current = head;
		int i = 1;
		boolean flag = false;
		
		if (head == null) {
			System.out.println("List is Empty");
		}
		else {
			while(current != null) {
				if (current.data == data) {
					flag = true;
					break;
				}
				i++;
				current = current.next;
			}
		}
		
		if (flag) {
			System.out.println(data + " is present in the list at position : " + i);
		}
		else {
			System.out.println(data + " is not present in the list");
		}
	}
	
	public void show() {
		Node<T> current = head;
		
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
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.addNode(56);
		list.addNode(30);
		list.addNode(70);
		list.show();
		
		list.searchNode(30);
	}
}
