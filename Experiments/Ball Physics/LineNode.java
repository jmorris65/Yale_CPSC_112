public class LineNode {
   private double x1;
   private double x2;
   private double y1;
   private double y2;
   private double length;
   private double slope;
   private double xLength;
   private double yLength;
   private double normalAngle;
   private LineNode next;
   
   public LineNode(double firstX, double firstY, double lastX, double lastY) {
      x1 = firstX;
      y1 = firstY;
      x2 = lastX;
      y2 = lastY;
      
      double xDistance = (x2 - x1) / 2;
      double yDistance = (y2 - y1) / 2;
      
      double h = Math.pow(x2 - x1, 2.0);
      double k = Math.pow(y2 - y1, 2.0);
      length = Math.sqrt(h + k);
      xLength = Math.sqrt(h);
      yLength = Math.sqrt(k);
      slope = (y2 - y1) / (x2 - x1);
      if (x1 > x2) {
         xLength = -xLength;
      }
      
      if (y1 > y2) {
         yLength = -yLength;
      }
      normalAngle = -Math.atan(xDistance / yDistance);
   }
   
   public void draw() {
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.setPenRadius(0.004);
      PennDraw.line(x1, y1, x2, y2);
      if (next != null)
         next.draw();
   }
   
   public double getNormal() {
      return normalAngle;
   }
   
   public double getDegrees() {
      return Math.toDegrees(normalAngle);
   }
   
   public void setNext(LineNode l) {
      next = l;
   }
   
   public LineNode getNext() {
      return next;
   }
   
   public double[] getPointSlope() {
      double[] point = {x1, y1, xLength, yLength};
      return point;
   }
}