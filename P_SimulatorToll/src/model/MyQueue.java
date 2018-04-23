package model;

public class MyQueue <T>{
	private long size;
	private Node<T> head;
	

	public MyQueue() {
		this.size = 0;
		this.head = null;
	}
	
	public void enqueue(T data){
		Node<T> node = new Node<T>(data);
		if(this.head == null){
			head = node;
		}else{
			Node<T> currentNode = this.head;
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
		this.size ++;
	}
	
	public T dequeue(){
		T element = null;
		if (head != null) {
			element = head.getData();
			head = head.getNext();
	}
		
		if(size > 0){
			size --;
		}
		return element;
	}
	
	public T copyDequeue(){
		T data = null;
		if(head != null){
			data = this.head.getData();
		}
		return data;	
		
	}
	
	public T front(){
		T element = null;
		if(head != null)
			element = head.getData();
			return element;
	}
	
	public long size(){
		Node<T> actual = this.head;
		long cont = 0;
		while(actual != null){
			cont ++;
			actual = actual.getNext();
		}
		return cont;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void print(){
		Node<T> actual = head;
		while(actual != null){
			System.out.println(actual.getData());
			actual = actual.getNext();
		}
	}
	
}
