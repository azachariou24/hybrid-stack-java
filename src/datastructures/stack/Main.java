package datastructures.stack;

public class Main {
	
    public static void main(String[] args) {
    	
        /* Create a hybrid stack with a maximum size of 3 */
        HybridStack<Integer> stack = new HybridStack<>(3);
        
        /* Insert elements into the stack */
        System.out.println("Inserting elements into the stack...");
        
        stack.insert(10);	// Insert first element
        stack.insert(20);	// Insert second element
        stack.insert(30);	// Insert third element
        
        /* The next insertion will cause a new node to be created */
        stack.insert(40);	// Insert fourth element (should trigger new node)

        /* Display the current state of the stack */
        stack.display();

        /* Remove elements from the stack */
        System.out.println("Removing elements from the stack...");
        System.out.println("Removed: " + stack.remove());	// Remove and display top element
        System.out.println("Removed: " + stack.remove());	// Remove and display top element
        
        /* Display the current state of the stack again */
        stack.display();

        /* Remove the remaining elements */
        System.out.println("Removing remaining elements from the stack...");
        System.out.println("Removed: " + stack.remove());	// Remove last element

        /* Try to remove from an empty stack to see exception handling */
        try {
        	
            stack.remove();	// This should throw an exception as the stack is now empty
            
        } catch (IllegalStateException e) {
        	
            System.out.println(e.getMessage());	// Catch and print the exception message
            
        }
        
        /* Reset the stack for testing removeMin */
        stack.insert(5);
        stack.insert(3);
        stack.insert(8);
        stack.insert(1);
        stack.insert(2);
        stack.insert(3);	// Duplicate for testing

        /* Display the stack before removing minimum */
        System.out.println("Stack before removing minimum:");
        
        stack.display();

        /* Remove the minimum value */
        try {
        	
           // Integer minValue = stack.removeMin();
            
          //  System.out.println("Removed minimum value: " + minValue);
            
        } catch (IllegalStateException e) {
        	
            System.out.println(e.getMessage());
            
        }

        /* Display the state of the stack after removing minimum */
        System.out.println("Stack after removing the minimum value:");
        
        stack.display();

        /* Create separate stacks so each algorithm gets the same input data */
        HybridStack<Integer> stackForQueue = new HybridStack<Integer>(3);
        HybridStack<Integer> stackForStack = new HybridStack<Integer>(3);
        HybridStack<Integer> stackForCompress = new HybridStack<Integer>(3);

        /* Sample values used to demonstrate the stack algorithms */
        int[] sampleValues = {5, 3, 8, 1, 2, 3, 1};

        /* Load the same values into each stack copy */
        for(int value : sampleValues) {
	        stackForQueue.insert(value);
	        stackForStack.insert(value);
	        stackForCompress.insert(value);
        }

        /* Run the minimum-removal algorithm that uses a helper queue */
        System.out.println("Original stack for removeMinUsingQueue:");
        stackForQueue.display();

        Integer minFromQueue = StackAlgorithms.removeMinUsingQueue(stackForQueue);
        System.out.println("Removed minimum using queue: " + minFromQueue);
        stackForQueue.display();

        /* Run the minimum-removal algorithm that uses a helper stack */
        System.out.println("Original stack for removeMinUsingStack:");
        stackForStack.display();

        Integer minFromStack = StackAlgorithms.removeMinUsingStack(stackForStack);
        System.out.println("Removed minimum using stack: " + minFromStack);
        stackForStack.display();

        /* Run the compression algorithm for consecutive equal values */
        System.out.println("Original stack for compress:");
        stackForCompress.display();

        StackAlgorithms.compress(stackForCompress);

        /* Show the final compressed stack */
        System.out.println("Compressed stack:");
        stackForCompress.display();
        
    }
    
}
