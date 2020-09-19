/* Name: Jalil Morris
 *
 * Net ID: jim33
 *
 * Execution: java HarpString
 *
 * Simulate a harp string using a ring buffer
 *
 */
public class HarpString {

   private RingBuffer buffer; // ring buffer
   private static int SAMPLING_RATE = 44100; // sampling rate
   private int timeStep;
   private static double KARPLUS_STRONG = -0.997;
   private int numSamples;

   // create a harp string of the given frequency
   public HarpString(double frequency) {
      numSamples = (int) Math.ceil(SAMPLING_RATE / frequency);
      buffer = new RingBuffer(numSamples);
      for (int i = 0; i < numSamples; i++)
         buffer.enqueue(0.0);
      timeStep = 0;
   }

   // pluck the harp string by replacing the buffer with white noise
   public void pluck() {
      for (int i = 0; i < numSamples; i++) {
         buffer.dequeue();
         buffer.enqueue((0.49999 * Math.random()) + (-0.5 * Math.random()));
      }
   }

   // advance the simulation one time step
   public void tic() {
      double a = buffer.peek();
      buffer.dequeue();
      double b = buffer.peek();
      double update = ((a + b) / 2) * KARPLUS_STRONG;
      buffer.enqueue(update);
      timeStep += 1;
   }

   // return the current sample
   public double sample() {
      return buffer.peek();
   }

   // return number of times tic was called
   public int time() {
      return timeStep;
   }

   public static void main(String[] args) {
      // how many samples should we "play"
      int numSamplesToPlay = Integer.parseInt(args[0]);  
   
      HarpString testString = new HarpString(44100.0 / numSamplesToPlay);
   
      testString.pluck();
      
      for (int i = 0; i < numSamplesToPlay; i++) {
         int t = testString.time();
         double sample = testString.sample();
      
         // this statement prints the time t, padded to 6 digits wide
         // and the value of sample padded to a total of 8 characters
         // including the decimal point and any - sign, and rounded
         // to four decimal places
         System.out.printf("%6d %8.4f\n", t, sample);
      
         testString.tic(); // advance to next sample
      }
   }
}
