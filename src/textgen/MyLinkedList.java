package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next=this.tail;
		this.tail.prev=this.head;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element==null) throw new NullPointerException("Cannot add Null value");
		LLNode<E> newNode = new LLNode<E>(element);
				
		newNode.prev=this.tail.prev;
		newNode.next=this.tail;
		this.tail.prev.next=newNode;
		this.tail.prev=newNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index<0 || index>=size) throw new IndexOutOfBoundsException();
		LLNode<E> temp = this.head;
		for (int i=0;i<=index;i++)
			temp =temp.next;
		return temp.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element==null) throw new NullPointerException("Cannot add Null value");

		if (index<0 || index>=size) throw new IndexOutOfBoundsException();
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> temp = this.head;
		for (int i=0;i<=index;i++)
			temp =temp.next;
		temp.prev.next=newNode;
		newNode.prev=temp;
		newNode.next=temp;temp.prev=newNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index<0 || index>=size) throw new IndexOutOfBoundsException();
		LLNode<E> temp = this.head;
		for (int i=0;i<=index;i++)
			temp =temp.next;
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		size--;
		return temp.data;
				
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index<0 || index>=size) throw new IndexOutOfBoundsException();
		if(element==null) throw new NullPointerException("Cannot add Null value");
		LLNode<E> temp = this.head;
		for (int i=0;i<=index;i++)
			temp =temp.next;
		E out = temp.data;
		temp.data = element;
		
		
		return out;
	}

	@Override
	public String toString() {
		LLNode<E> temp =head;
		String s="head -->";
		while(temp!=null){
			temp =temp.next;
			s+=temp.data + " -->";
		}
		s+= "total = "+size;
		return s;
	}   
	
	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
