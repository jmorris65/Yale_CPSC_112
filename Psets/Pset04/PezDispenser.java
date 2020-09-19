public class PezDispenser {
   private int red, green, blue; // pez color
   private boolean isSmall = true;
   private String headType;
   private int candiesLeft;
   private String flavor;
   
   public PezDispenser(/* arguments */) { // constructor no return type must be public
      // same name as class
      flavor = "red";
      candiesLeft = 0;
      red = green = blue = 255; // white
      headType = "yeti";
   }
   
   public PezDispenser(String flavor, int candiesLeft, String headType, 
      boolean isSmall, int red, int green, int blue) {
      
      this.flavor = flavor; // use this to state the main variable when a local variable has the same name 
      this.candiesLeft = candiesLeft;
      this.headType = headtype;
      this.isSmall = isSmall;
      this.red = red;
      this.blue = blue;
      this.green = green;
      
   }
   
   public void printState() {
      System.out.println(red + " " + blue + " " + green + " " + flavor + " " +
          "is Small: " + isSmall + " " + headType + " " + flavor + " " + candiesLeft);
   }
}