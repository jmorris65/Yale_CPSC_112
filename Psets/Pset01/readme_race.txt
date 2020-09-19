/**********************************************************************
 *  readme template
 *  pset 1: Conditionals and Loops
 **********************************************************************/

Name: Jalil Morris  
NetID: jim33
Hours to complete assignment (optional): 4



/**********************************************************************
 *  Have you enter all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help in outside of TA lab hours
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA lab hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 *
 **********************************************************************/





/**********************************************************************
 *  Problem A:  What is the output of the following code?
 * 
 *     for (int i = 0; i < 5; i++) { 
 *         for (int j = 0; j < i; j++) {
 *             System.out.print(i + j); 
 *         } 
 *         System.out.println(); 
 *     }
 * 
 *  You should work your answer out by hand first.  Once you've
 *  traced through the code manually, you can confirm it using DrJava.
 *********************************************************************/
1
23
345
4567


/**********************************************************************
 *  Problem B:  Translate the following while loop into an equivalent 
 *  for loop, without changing the initial value of n.  Once you have 
 *  done the conversion by hand, verify your answer using DrJava.
 * 
 *     int n = 50; 
 *     while (n > 0) { 
 *         n -= 2;
 *         System.out.println(n); 
 *     } 
 *********************************************************************/
for (int n = 50; n > 0; n -= 2) {
   System.out.println(n);
   }



/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Creating a polygon required several variables and it was difficult to change each one.



/**********************************************************************
 *  If you completed the extra credit or added any additional features,
 *  provide DETAILED and CLEAR instructions for how to use them and 
 *  what we should look for when grading your assignment.
 *********************************************************************/
It is similar to the Harvard v Yale race but with colored cars. In addition,
the cars have an equal chance of moving a particular distance so the race is fair.
I have also added a winner animation. The color of the winner closes around the winner.


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

