import java.util.EmptyStackException;

/**
 * This class implements the Stack interface by using an
 * Extendible array.
 */
public class StackAsArray implements Stack {

	/* Defines the initial capacity of a stack */
	private static final int INITIAL_CAPACITY = 5;
	/* Defines the capacity extension of a stack when it is full */
	private static final int CAPACITY_EXTENSION = 5;

	protected Object[] elements;
	protected int size;
	
	/**
	  * Creates a new stack.
	  */
	public StackAsArray() {
		elements = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	/**
	  * @param o an object that is inserted into the stack.
	  */
	public void push(Object o) {
		// Make sure there is enough room in the array
		if (size >= elements.length) {
			extend();
		}
		elements[size] = o;
		size++;
	}
	
	/**
	  * @return the last value that was pushed in the stack
	  */
	public Object pop() {
		// If there are no elements, an exception is thrown
		if (size == 0)
			throw new EmptyStackException();
		size--;
	return elements[size];
	}
	
	/**
	  * @return true if the stack is empty, else false.
	  */
	public boolean isEmpty() {
		return size == 0;
	}

	
	/**
	  * Extends the size of the array by CAPACITY_EXTENSION.
	  */
	private void extend() {
		// Create a new array with the new size
		Object[] tmpArray = new Object[elements.length + CAPACITY_EXTENSION];
		
		// Copy the old elements to the new array
		for (int i = 0; i < elements.length; i++)
			tmpArray[i] = elements[i];
		
		// Replace the elements array with the new one
		elements = tmpArray;
	}
}