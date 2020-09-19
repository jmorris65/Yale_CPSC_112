public class TubeNode {
   private Tube obstacle;
   private TubeNode next;
   private boolean pointAvailable;
   
   public TubeNode() {
      obstacle = new Tube();
      next = null;
      pointAvailable = true;
   }
   
   public void setNext(TubeNode n) {
      next = n;
   }
   
   public Tube getTube() {
      return obstacle;
   }
   
   public TubeNode getNext() {
      return next;
   }
   
   public int addPoint() {
      int count = 0;
      if (pointAvailable && getTube().getRange()[1] < -40) {
         pointAvailable = false;
         count = 1;
      }
      else if (next != null)
         count = next.addPoint();
      return count;
   }
   
   public void moveTubes(int frames) {
      obstacle.move(frames);
      if (next != null) next.moveTubes(frames);
      return;
   }
}