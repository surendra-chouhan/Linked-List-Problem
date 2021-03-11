package myLinkedList;

import java.util.List;

public class LinkedList<T extends Comparable<T>> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
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
	
	public void insertAfterGivenNode(Node<T> previous, T data) {
		if (previous == null) {
			System.out.println("Previous Node cannot be null");
			return;
		}
		Node<T> newNode = new Node<T>(data);
		newNode.next = previous.next;
		previous.next = newNode;
	}
	
	public void deleteAfterGivenNode(T key) {
		Node<T> temp = head;
		Node<T> previous = null;
		
		if(temp != head && temp.data == key) {
			head = temp.next;
			return;
		}
		
		while(temp != null && temp.data != key) {
			previous = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			return;
		}
		previous.next = temp.next;
	}
	
	public void sortList() {
		Node current = head;
		Node index = null;
		T temp;
		
		if(head == null) {
			return;
		}
		else {
			while(current != null) {
				index = current.next;
				while(index != null) {
					if(((Comparable<T>) current.data).compareTo((T) index.data) > 0) {
						temp = (T) current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
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
		list.addNode(70);
		list.insertAtMiddle(30,1);
		list.show();
		
		System.out.println("Inserting Element after 30");
		list.insertAfterGivenNode(list.head.next,40);
		list.show();
		
		System.out.println("After Sorting the list is : ");
		list.sortList();
		list.show();
	}
}
