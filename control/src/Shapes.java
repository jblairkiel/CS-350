// Fig. 5.26: Shapes.java
// Demonstrates drawing different shapes.
import java.awt.*;
import javax.swing.JPanel;

public class Shapes extends JPanel
{
   private int choice; // user's choice of which shape to draw
   
   // constructor sets the user's choice
   public Shapes( int userChoice )
   {
      choice = userChoice;
   } // end Shapes constructor
   
   // draws a cascade of shapes starting from the top-left corner
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      
      g.setColor(Color.red);
      
      for ( int i = 0; i < 10; i++ )
      {
         // pick the shape based on the user's choice
         switch ( choice )
         {
            case 1: // draw rectangles
               g.drawRect( 10 + i * 10, 10 + i * 10, 
                  50 + i * 10, 50 + i * 10 );
               break;
            case 2: // draw ovals
//               g.drawOval( 10 + i * 10, 10 + i * 10, 
//                  50 + i * 10, 50 + i * 10 );
               g.drawArc( 10 + i * 10, 10 + i * 10, 
                       50 + i * 10, 50 + i * 10, 0, 360 );
               break;
            case 3: // fill rectangles
                g.fillRect( 10 + i * 10, 10 + i * 10, 
                   50 + i * 10, 50 + i * 10 );
                break;
            case 4: // fill ovals
//                g.fillOval( 10 + i * 10, 10 + i * 10, 
//                   50 + i * 10, 50 + i * 10 );
                g.fillArc( 10 + i * 10, 10 + i * 10, 
                        50 + i * 10, 50 + i * 10, 0, 360 );
                break;
            default: // draw lines
                g.drawLine( 10 + i * 10, 60 + i * 20, 
                   60 + i * 20, 10 + i * 10 );
                break;
         } // end switch
      } // end for
      
      // added by Zhang
      int x=20;
      int y=getHeight()-20;
      if (choice==1) {
    	  g.drawString("10 rectangles drawn", x, y);
      }
      else if (choice==2) {
    	  g.drawString("10 circles drawn", x, y);
      }
      else if (choice==3) {
    	  g.drawString("10 rectangles filled", x, y);
      }
      else if (choice==4) {
    	  g.drawString("10 circles filled", x, y);
      }
      else {
    	  g.drawString("10 lines drawn", x, y);    	 
      }
      choice=(choice+1)%5;
      // end of addition
      
   } // end method paintComponent
} // end class Shapes


/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
