/* Name: Jalil Morris
 * 
 * Net ID: jim33
 *
 * Execution: java RingBuffer
 *
 * Create a Ring Buffer for the Harp String 
 *
 */

public class RingBuffer {
   private double[] bufferArray; // Items in the buffer
   private int first;            // Index for the next dequeue or peek
   private int last;             // Index for the next enqueue
   private int currentSize;      // Number of items in the buffer

   // Create an empty buffer, with given max capacity
   public RingBuffer(int capacity) {
      bufferArray = new double[capacity];
      currentSize = 0;
      first = 0;
      last = 0;
   }

   // Return number of items currently in the buffer
   public int currentSize() {
      return currentSize;
   }

   // is the buffer empty (size equals zero)?
   public boolean isEmpty() {
      if (currentSize == 0) 
         return true;
      else 
         return false; // dummy return statement so the code compiles
   }

   // is the buffer full (size equals array capacity)?
   public boolean isFull() {
      if (currentSize == bufferArray.length)
         return true;
      else
         return false;
   }

   // add item x to the end
   public void enqueue(double x) {
      if (isFull()) {
         throw new RuntimeException("ERROR: Attempting to enqueue " +
                                    "to a full buffer.");
      }
      bufferArray[last] = x;
      last += 1;
      if (last == bufferArray.length) 
         last = 0;
      currentSize += 1;
   }

   // delete and return item from the front
   public double dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("ERROR: Attempting to dequeue " +
                                    "from an empty buffer.");
      }
      double x = bufferArray[first];
      bufferArray[first] = 0;
      first += 1;
      if (first == bufferArray.length)
         first = 0;
      currentSize -= 1;
      return x;
   }

   // return (but do not delete) item from the front
   public double peek() {
      if (isEmpty()) {
         throw new RuntimeException("ERROR: Attempting to peek " +
                                    "at an empty buffer.");
      }
      return bufferArray[first];
   }

   // print the contents of the RingBuffer object for debugging
   private void printBufferContents() {
      // print out first, last, and currentSize
      System.out.println("first:        " + first);
      System.out.println("last:         " + last);
      System.out.println("currentSize:  " + currentSize);
      System.out.println("isFull:       " + isFull());
      System.out.println("isEmpty:      " + isEmpty());
   
      // print bufferArray's length and contents if it is not null
      // otherwise just print a message that it is null
      if (bufferArray != null) {
         System.out.println("array length: " + bufferArray.length);
         System.out.println("Buffer Contents:");
         for (int i = 0; i < bufferArray.length; i++) {
            System.out.println(bufferArray[i]);
         }
      } else {
         System.out.println("bufferArray is null");
      }
   }
   
   // returns position of first number in buffer
   public double[] toDoubleArray() {
      return bufferArray;
   }

   // a simple test of the constructor and methods in RingBuffer
   public static void main(String[] args) {
      // create a RingBuffer with bufferSize elements
      // where bufferSize is a command-line argument
      int bufferSize = Integer.parseInt(args[0]);
      RingBuffer buffer = new RingBuffer(bufferSize);
      
      buffer.enqueue(7.8);
      buffer.enqueue(1.2);
      buffer.enqueue(5.4);
      buffer.enqueue(8.9);
      buffer.enqueue(3.5);
      buffer.enqueue(7.8);
      buffer.enqueue(7.8);
      buffer.enqueue(7.8);
      
      buffer.dequeue();
      buffer.dequeue();
      buffer.dequeue();
      buffer.dequeue();
      buffer.dequeue();
      buffer.dequeue();
      buffer.dequeue();
      buffer.dequeue();
      
      buffer.printBufferContents();
      System.out.println();
   }

}