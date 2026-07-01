package datastructures.stack;

public class CircularQueue<T> {
	
	private int front;		// Index of the front element
	private int rear;		// Index of the rear element
	private int maxSize;	// Maximum size of the queue
	private T[] array;	// Array to store the queue elements
	
	private static final int MINUS_ONE = -1;	// Constant for indicating an empty state
	private static final int ZERO = 0;			// Constant for zero value
	private static final int ONE = 1;			// Constant for one value
	private static final int FOUR = 4;			// Constant for four value
	
	/**
     * Constructor to initialize the circular queue with specific front, rear, and size.
     * 
     * @param aFront The initial index of the front element.
     * @param aRear The initial index of the rear element.
     * @param aMaxSize The maximum size of the queue.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public CircularQueue(int aFront, int aRear, int aMaxSize) {
		
		this.front = aFront;		// Set the front index
		this.rear = aRear;			// Set the rear index
		this.maxSize = aMaxSize;	// Set the maximum size of the queue
		this.array = (T[]) new Object[this.maxSize];	// Initialize the array with the maximum size
		
	}
	
	/**
     * Constructor to initialize the circular queue with a specified maximum size.
     * 
     * @param aMaxSize The maximum size of the queue.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public CircularQueue(int aMaxSize) {
		
		this.front = MINUS_ONE;			// Set front to indicate the queue is empty
		this.rear = MINUS_ONE;			// Set rear to indicate the queue is empty
		
		this.maxSize = aMaxSize;		// Set the maximum size of the queue
		this.array = (T[]) new Object[this.maxSize];	// Initialize the array
		
	}
	
	/**
     * Default constructor that initializes the circular queue with a default size of 4.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public CircularQueue() {
		
		this.front = MINUS_ONE;			// Initialize front as empty
		this.rear = MINUS_ONE;			// Initialize rear as empty
		
		this.maxSize = FOUR;			// Default maximum size
		this.array = (T[]) new Object[this.maxSize];	// Initialize the array
		
	}
	
	/**
     * Checks if the queue is empty.
     * 
     * @return boolean => true if the queue is empty, false otherwise.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public boolean isEmpty() {
		
		/* Return true if front index is -1, indicating the queue is empty */
		return (this.front == MINUS_ONE);	// or the same is return(this.rear == MINUS_ONE);
		
	}
	
	/**
     * Adds an element to the rear of the queue.
     * 
     * @param aValue The <T> value to be added to the queue.
     * @return boolean => true if the element was added successfully, false if the queue is full.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public boolean enQueue(T aValue) {
		
		if(this.isFull()) {
			
			System.out.println("The Queue is full!");	// Print a message if the queue is full
			
			return (false);	// Indicate failure to add the element
			
		}
		
		else {
			
			if(this.isEmpty()){
				
				this.front = ZERO;	// Set front to the first position
				this.rear = ZERO;	// Set rear to the first position
				
			}
		
			else {
			
				this.rear = this.nextPosition(this.rear);	// Move rear to the next position
			
			}
			
			this.array[this.rear] = aValue;	// Add the new element at the rear position
			
		}
		
		return (true);	// Indicate success
		
	}
	
	/**
     * Removes and returns the front element of the queue.
     * 
     * @return The front element of the queue.
     * 
     * @throws IllegalStateException if the queue is empty.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public T deQueue() {
		
		/* Check if the queue is empty before attempting to remove an element */
		if(this.isEmpty()) {
			
			/* Throw an exception if the queue is empty */
			throw new IllegalStateException("The Queue is empty! Cannot remove an element.");
			
		}
			
		int number = this.front;	// Store the current front index
			
		if(this.rear == this.front) {	// Check if the queue will be empty after removal
				
			this.front = MINUS_ONE;		// Reset front to indicate empty queue
			this.rear = MINUS_ONE;		// Reset rear to indicate empty queue
				
		}
			
		else {
				
			this.front = this.nextPosition(this.front);	// Move front to the next position
				
		}
			
		return (this.array[number]);	// Return the removed element
			
	}
	
	/**
     * Retrieves the last element added to the queue without removing it.
     * 
     * @return The last element of the queue.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public T top() {
		
		return ( this.array[this.rear] );	// Return the element at the rear position
		
	}
	
	/**
     * Gets the current number of elements in the queue.
     * 
     * @return The size of the queue.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	public int size() {
		
		/* If rear is greater than or equal to front, calculate size directly */
		if(this.rear >= this.front) {
			
			return ( this.rear - (this.front) + ONE );	// Calculate size
			
		}
		
		/* If rear has wrapped around, calculate size using maxSize */
		return ( (this.maxSize - (this.front - this.rear) + ONE));
		
	}
	
	/**
	 * Returns a string representation of the queue's contents.
	 * 
	 * This method constructs a visual representation of the queue, 
	 * including elements and place holders if the queue is empty.
	 * 
	 * @return A formatted string displaying the elements of the queue,
	 *         or a message indicating that the queue is empty.
	 * 
	 * @since 23/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public String toString() {
		
		String circularQ = "";	// String to hold the display output
		
		if(this.isEmpty()) {
			
			circularQ += ("The Queue now is Empty!" + '\n');	// Message for empty queue
			
			for(int i = ZERO; i < this.maxSize; i++)
				
				circularQ += "   |   ";	// Placeholder for empty spaces
			
			return (circularQ);	// Return the empty display
				
		}
		
		circularQ += "|   ";	// Space before the first element
		circularQ += this.array[this.front];	// Add the front element to the display
		
		int copyFront = this.nextPosition(this.front);	// Start from the next position of front
		
		int count = ONE;	// Initialize count
		
		/* Loop through the queue and add elements to the display string */
		while(count < this.size()) {
			
			circularQ += "   |   ";	// Separator
			circularQ += this.array[copyFront];	// Add the next element
			
			count++;	// Increment count
			
			copyFront = this.nextPosition(copyFront);	// Move to the next position
			
		}
		
		circularQ += "   |";	// Separator
		
		return (circularQ);	// Return the complete display string
		
	}
	
	/**
	 * Displays the contents of the queue.
	 * 
	 * This method prints the elements of the queue in order, surrounded by dividers.
	 * If the queue is empty, it indicates that the queue is empty with a specific message.
	 * 
	 * @since 23/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void display(){
		
		if(this.isEmpty()) {	// Check if the queue is empty
			
			System.out.println("The Queue now is Empty!");	// Print message if empty
			
			System.out.print("|   ");
			
			/* Print the structure of the empty queue */
			for(int i = ZERO; i < this.maxSize; i++)
				
				System.out.print("   |   ");	// Print empty place holders for each slot
			
			System.out.println("   |");	// End of the queue display
			
			return ;	// Exit the method as there is nothing to display
			
		}
		
		int i = ZERO;	// Initialize counter for loop
		
		System.out.print("|   ");	// Start of the queue display
		
		/* Loop through each element in the queue */
		while(i <= (this.size())) {
			
			/* Remove the front element of the queue */
			T popNumber = this.deQueue();
			
			System.out.print(popNumber + "   |   ");	// Print the dequeued element
			
			/* Reinsert the element back into the queue */
			this.enQueue(popNumber);	// Maintain the queue's integrity
			
			i++;	// Increment counter
			
		}
		
		System.out.println("   |");	// End of the queue display
		
	}
	
	/**
     * Checks if the queue is full.
     * 
     * @return boolean => true if the queue is full, false otherwise.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	private boolean isFull() {
		
		/* Check if front is at the next position of rear */
		return (this.front == this.nextPosition(this.rear));
		
	}
	
	/**
     * Calculates the next position in the circular queue.
     * 
     * @param aNumber the current position.
     * @return The next position in the circular queue.
     * 
     * @since 23/09/2024
     * @version 1.0
     * @author Anastasis Zachariou
     */
	private int nextPosition(int aNumber) {
		
		/* Calculate next position with wrap-around */
		return ( (aNumber + ONE) % this.maxSize );
		
	}

}
