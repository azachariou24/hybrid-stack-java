package datastructures.stack;

class HybridStackNode<T> {
	
	private static final int MINUS_ONE = -1;	// Constant for indicating an empty state
	private static final int ZERO = 0;			// Constant for zero value
	private static final int ONE = 1;			// Constant for one value
	private static final int FOUR = 4;			// Constant for four value
	
	/* Inner class Node to hold stack elements */
	private class Node {
		
		private T[] elements;	// Array to store stack elements
		private Node next;		// Reference to the next node
		private int top;		// Index of the top element in the stack
		private int maxSize;	// Maximum size of the stack
		
		/**
		 * Constructor to initialize the node with a specified maximum size.
		 * 
		 * @param aMaxSize The maximum size of the stack.
		 * 
		 * @since 30/09/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public Node(int aMaxSize) {
			
			this.maxSize =  aMaxSize;	// Set the maximum size
			
			this.elements = (T[]) new Object[this.maxSize];	// Create the elements array
			this.next = null;	// Initially no next node
			
			this.top = MINUS_ONE;	// Initially, the stack is empty
			
		}
		
		/**
		 * Default constructor initializing the node with a default size.
		 * 
		 * @since 30/09/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public Node() {
			
			this.maxSize =  FOUR;	// Default size
			
			this.elements = (T[]) new Object[this.maxSize];	// Create the elements array
			this.next = null;	// Initially no next node
			
			this.top = MINUS_ONE;	// Initially, the stack is empty
			
		}
		
		/**
		 * Checks if the node is full.
		 * 
		 * @return boolean => true if the node is full, false otherwise.
		 * 
		 * @since 30/09/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public boolean isFull() {
			
			return (this.top == (this.maxSize - ONE));
			
		}
		
		/**
		 * Checks if the node is empty.
		 * 
		 * @return boolean => true if the node is empty, false otherwise.
		 * 
		 * @since 30/09/2024
		 * @version 1.0
		 * @author Anastasis Zachariou 
		 */
		public boolean isEmpty() {
			
			return (this.top == MINUS_ONE);
			
		}
		
		/**
		 * Pushes an element onto the stack.
		 * 
		 * @param aValue The value to be pushed onto the stack.
		 * 
		 * @since 30/09/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public void push(T aValue) {
			
			this.elements[++this.top] = aValue;	// Increment top and add the value
			
		}
		
		/**
		 * Pops an element from the stack.
		 * 
		 * @return The value at the top of the stack.
		 * 
		 * @since 30/09/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public T pop() {
			
			return (this.elements[top--]);	// Return the top element and decrement top
			
		}
		
	}
	
	private Node head;	// Head node of the hybrid stack
	
	/**
	 * Constructor to initialize the hybrid stack with a specified maximum size.
	 * 
	 * @param aMaxSize The maximum size of the stack.
	 * 
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public HybridStackNode(int aMaxSize) {
		
		this.head = new Node(aMaxSize);	// Initialize head with a new node
		
	}
	
	/**
	 * Default constructor initializing the hybrid stack with a default size.
	 * 
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public HybridStackNode() {
		
		this.head = new Node();	// Initialize head with default size
		
	}
	
	/**
	 * Inserts a value into the stack.
	 * 
	 * @param aValue The value to be inserted into the stack.
	 * 
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void insert(T aValue) {
		
		if(this.head.isFull()) {	// Check if the head node is full
			
			Node newNode = new Node();	// Create a new node
			newNode.next = this.head;	// Point new node to the current head
			this.head = newNode;	// Update head to the new node
			
		}
		
		this.head.push(aValue);	// Push the value onto the stack
		
	}
	
	/**
	 * Removes and returns the top value from the stack.
	 * 
	 * @return The top value from the stack.
	 * 
	 * @throws IllegalStateException if the stack is empty.
	 * 
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public T remove() {
		
		if(this.isEmpty()) {	// Check if the stack is empty
			
			throw new IllegalStateException("The Stack is empty!");	// Throw exception if empty
			
		}
		
		T value = this.head.pop();	// Pop the top value
		
		/* If the current head is empty and has a next node, move to the next node */
		if((this.head.isEmpty()) && (this.head.next != null)) {
			
			this.head = this.head.next;	// Update head to the next node
			
		}
		
		return (value);	// Return the popped value
		
	}
	
	/**
	 * Checks if the stack is empty.
	 * 
	 * @return boolean => true if the stack is empty, false otherwise.
	 * 
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public boolean isEmpty() {
		
		/* Check if head is empty and has no next */
		return ((this.head.isEmpty()) && (this.head.next == null));	
		
	}
	
	/**
	 * Calculates the total number of elements stored in the stack.
	 *
	 * @return int => the number of elements currently stored in the stack.
	 *
	 * @since 01/07/2026
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public int size() {
		
		int count = ZERO;
		Node currentNode = this.head;
		
		while(currentNode != null) {
			
			count += (currentNode.top + ONE);
			currentNode = currentNode.next;
			
		}
		
		return (count);
		
	}
	
	/**
	 * Displays the elements of the stack.
	 * 
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void display() {
		
		if(this.isEmpty()) {	// Check if the stack is empty
			
			System.out.println("The Stack is empty!");	// Print message if empty
			
			return ;
			
		}
		
		Node currentNode = this.head;	// Start from the head node
		
		int nodeIndex = ONE;	// Index for nodes
		
		System.out.println("The Stack:");
		
		while(currentNode != null) {	// Traverse through nodes
			
			System.out.print("Node " + nodeIndex + ": ");	// Print current node index
			
			System.out.print("| ");
			
			/* Print elements from top to bottom */
			for(int i = (currentNode.top); i >= ZERO; i--) {
				
				System.out.print(currentNode.elements[i] + " | ");	// Print each element
				
			}
			
			System.out.println();	// Print a new line
			
			currentNode = currentNode.next;	// Move to the next node
			nodeIndex++;	// Increment node index
			
		}
		
		System.out.println();	// Print a new line
		
	}
	
}
