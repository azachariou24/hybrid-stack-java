package datastructures.stack;

public class StackAlgorithms {

	private static final int ZERO = 0;			// Constant for zero value
	private static final int ONE = 1;			// Constant for one value

	/**
	 * Removes all occurrences of the minimum value from the stack using a
	 * helper queue and returns that minimum value.
	 *
	 * The order of the remaining elements is preserved.
	 *
	 * @param aStack The stack to process.
	 *
	 * @return The minimum value that was removed from the stack.
	 *
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public static <T extends Comparable<? super T>> T removeMinUsingQueue(HybridStack<T> aStack) {
		
		if((aStack == null) || (aStack.isEmpty())) {
			
			throw new IllegalStateException("The Stack is empty!");
			
		}
		
		CircularQueue<T> helperQueue = new CircularQueue<T>(aStack.size());
		T minValue = null;
		int elementCount = ZERO;
		
		/* Move all stack elements into the queue and find the minimum value */
		while(!aStack.isEmpty()) {
			
			T value = aStack.remove();
			helperQueue.enQueue(value);
			
			if((minValue == null) || (value.compareTo(minValue) < ZERO)) {
				
				minValue = value;
				
			}
			
			elementCount++;
			
		}
		
		/* Rebuild the stack in the original order while skipping the minimum value */
		for(int remaining = elementCount; remaining > ZERO; remaining--) {
			
			for(int i = ONE; i < remaining; i++) {
				
				helperQueue.enQueue(helperQueue.deQueue());
				
			}
			
			T value = helperQueue.deQueue();
			
			if(!value.equals(minValue)) {
				
				aStack.insert(value);
				
			}
			
		}
		
		return (minValue);
		
	}
	
	/**
	 * Removes all occurrences of the minimum value from the stack using a
	 * helper stack and returns that minimum value.
	 *
	 * The order of the remaining elements is preserved.
	 *
	 * @param aStack The stack to process.
	 *
	 * @return The minimum value that was removed from the stack.
	 *
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public static <T extends Comparable<? super T>> T removeMinUsingStack(HybridStack<T> aStack) {
		
		if((aStack == null) || (aStack.isEmpty())) {
			
			throw new IllegalStateException("The Stack is empty!");
			
		}
		
		HybridStack<T> helperStack = new HybridStack<T>();
		T minValue = null;
		
		/* Move all stack elements into the helper stack and find the minimum value */
		while(!aStack.isEmpty()) {
			
			T value = aStack.remove();
			helperStack.insert(value);
			
			if((minValue == null) || (value.compareTo(minValue) < ZERO)) {
				
				minValue = value;
				
			}
			
		}
		
		/* Restore the stack while removing the minimum value */
		while(!helperStack.isEmpty()) {
			
			T value = helperStack.remove();
			
			if(!value.equals(minValue)) {
				
				aStack.insert(value);
				
			}
			
		}
		
		return (minValue);
		
	}
	
	/**
	 * Compresses each consecutive sequence of equal integers in the stack into
	 * a pair [count, value], preserving the order of the sequences.
	 *
	 * The helper queue is displayed before the method returns.
	 *
	 * @param aStack The stack to compress.
	 *
	 * @since 30/09/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public static void compress(HybridStack<Integer> aStack) {
		
		if((aStack == null) || (aStack.isEmpty())) {
			
			CircularQueue<Integer> emptyQueue = new CircularQueue<Integer>(ONE);
			emptyQueue.display();
			return;
			
		}
		
		CircularQueue<Integer> helperQueue = new CircularQueue<Integer>(aStack.size());
		int elementCount = ZERO;
		
		/* Move all elements from the stack into the queue */
		while(!aStack.isEmpty()) {
			
			helperQueue.enQueue(aStack.remove());
			elementCount++;
			
		}
		
		/* Show the queue contents before returning, as requested */
		helperQueue.display();
		
		Integer currentValue = null;
		int currentCount = ZERO;
		
		/* Traverse the queue from the bottom of the original stack to the top */
		for(int remaining = elementCount; remaining > ZERO; remaining--) {
			
			for(int i = ONE; i < remaining; i++) {
				
				helperQueue.enQueue(helperQueue.deQueue());
				
			}
			
			Integer value = helperQueue.deQueue();
			
			if(currentValue == null) {
				
				currentValue = value;
				currentCount = ONE;
				
			}
			else if(currentValue.equals(value)) {
				
				currentCount++;
				
			}
			else {
				
				aStack.insert(currentCount);
				aStack.insert(currentValue);
				
				currentValue = value;
				currentCount = ONE;
				
			}
			
		}
		
		/* Insert the last compressed pair */
		if(currentValue != null) {
			
			aStack.insert(currentCount);
			aStack.insert(currentValue);
			
		}
		
	}
	
}