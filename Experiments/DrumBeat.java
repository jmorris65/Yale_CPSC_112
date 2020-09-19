public class DrumBeat {

   private RingBuffer buffer; // ring buffer
   private static int SAMPLING_RATE = 44100; // sampling rate
   private int timeStep;
   private static double KARPLUS_STRONG = -1.00;
   private int numSamples;

   // create a harp string of the given frequency
   public DrumBeat(double frequency) {
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
      double update = ((a + b) / 2) * (2 * Math.random() + KARPLUS_STRONG);
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
}