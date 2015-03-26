import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Frank Hucek
 * Programming Project 3
 * Due Date: 11/7/2014 A.D.
 * SlideGame class
 * This class contains the UI settings and details needed to play the Slide Game
 */

public class SlideGame extends JFrame implements ActionListener
{
     // Number of rows in this instance of the game
  private int rows;
     // Number of columns in this instance of the game
  private int columns;
     // Number of blankButtons at any 1 time.
  private int blankButtons = 0;
  /**
   * 2D array with type JButton
   */
  JButton[][] button;
  /**
   * 2D array with type int to represent button values
   */
  int[][] buttonValue;
  /**
   * Constructor initializing values of Buttons and Button Values and setting up the game.
   * @param rows Represents the rows of buttons for this instance of the game.
   * @param columns Represents the columns of buttons for this instance of the game.
   */
  public SlideGame(int rows, int columns)
  {
    this.rows = rows;
    this.columns = columns;
    button = new JButton[rows][columns];
    buttonValue = new int[rows][columns];
    Container container = this.getContentPane();
    JPanel panel = new JPanel(new GridLayout(rows,columns));
    
       // Creates instances of JButton in button array and adds each button to ActionListener and panel.
       // Sets all buttons to 0.
    for(int i = 0; i < button.length; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        button[i][j] = new JButton();
        button[i][j].addActionListener(this);
        panel.add(button[i][j]);
        buttonValue[i][j] = 0;
      }
    }
    container.add(panel, "Center");
    this.pack();
    this.setSize(100*columns, 100*rows);
  }
  
  /**
   * Refreshes the text on each button
   * If the button value is 0, print nothing on button. Otherwise print buttonValue on button.
   */
  public void setText()
  {
    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        if(buttonValue[i][j] != 0)
          button[i][j].setText("" + buttonValue[i][j]);
        else 
          button[i][j].setText("");
      }
    }
  }
  
  /**
   * Counts the number of blankButtons on the grid.
   * Sets a random number "1" to a blank button on the grid.
   */
  public void randomAssign()
  {
    boolean randomized = false;
    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        if(buttonValue[i][j] == 0)
          this.blankButtons++;
      }
    }  
       // If nothing has been randomized yet, keep running.
       // Randomly select a button, if it has no value > 0, add a 1 to it.
    while(!randomized)
    {
       int randomrow = (int)(Math.random() * (rows));
       int randomcol = (int)(Math.random() * (columns));
       if(buttonValue[randomrow][randomcol] == 0)
       {
         buttonValue[randomrow][randomcol] = 1;
         button[randomrow][randomcol].setText("" + buttonValue[randomrow][randomcol]);
         randomized = true;
       }

    }
    setText();
  }
  
  /**
   * ActionPerformed method from ActionListener.
   * Recognizes an action on a specific button, and performs respective operation.
   * @param e This is the ActionEvent the ActionListener was waiting for.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
       // Gets the source of the button that was pressed
    JButton b = (JButton)e.getSource();
       // Creates an instance of SlideGameMethods
    SlideGameMethods slide = new SlideGameMethods();
    int bRow = 0;
    int bCol = 0;
    
       // Finds which button[bRow][bCol] equals the address of b. Just like solving a mystery.
    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        if(button[i][j].equals(b))
        {
          bRow = i;
          bCol = j; 
        }
      }
    }
    
       // Determines if something was moved.
    boolean slid = false;
       
       // Perform slideLeft method on each row. Then, refreshes the grid and sets random value.
    if(bCol == 0 && bRow != 0 && bRow != rows - 1) // Slides Left
    {
      for(int i = 0; i < rows; i++)
      {
        slid = slide.slideLeft(buttonValue,i);
      }
      setText();
      randomAssign();
    }
       // Perform slideRight method on each row. Then, refreshes the grid and sets random value.
    else if(bCol == columns - 1 && bRow != 0 && bRow != rows - 1) // Slides Right
    {
      for(int i = 0; i < rows; i++)
        slid = slide.slideRight(buttonValue,i);
      setText();
      randomAssign();
    }
       // Perform slideUp method on each column. Then, refreshes the grid and sets random value.
    else if(bRow == 0 && bCol != 0 && bCol != columns - 1) // Slides Up
    {
      for(int i = 0; i < columns; i++)
        slid = slide.slideUp(buttonValue,i);
      setText();
      randomAssign();
    }
       // Perform slideDown method on each column. Then, refreshes the grid and sets random value. 
    else if(bRow == rows - 1 && bCol != 0 && bCol != columns - 1) // Slides Down
    {
      for(int i = 0; i < columns; i++)
        slid = slide.slideDown(buttonValue,i);
      setText();
      randomAssign();
    }
       // Perform slideUpLeft method on each column and row correctly. Then, refreshes the grid and sets random value.
    else if(bRow == 0 && bCol == 0) // Slides Up and to the Left
    {
      for(int i = 0; i < rows; i++)
        slid = slide.slideUpLeft(buttonValue,i,0);
      for(int j = 1; j < columns; j++)
        slid = slide.slideUpLeft(buttonValue,0,j);
      setText();
      randomAssign();
    }
       // Perform slideUpRight method on each column and row correctly. Then, refreshes the grid and sets random value.
    else if(bRow == 0 && bCol == columns - 1) // Slides Up and to the Right
    {
      for(int i = 0; i < rows; i++)
        slid = slide.slideUpRight(buttonValue,i,0);
      for(int j = 1; j < columns; j++)
        slid = slide.slideUpRight(buttonValue,rows - 1,j);
      setText();
      randomAssign();
    }
       // Perform slideDownLeft method on each column and row correctly. Then, refreshes the grid and sets random value.
    else if(bRow == rows - 1 && bCol == 0) // Slides Down and to the Left
    {
      for(int i = 0; i < rows; i++)
        slid = slide.slideDownLeft(buttonValue,i,0);
      for(int j = 1; j < columns; j++)
        slid = slide.slideDownLeft(buttonValue,rows - 1,j);
      setText();
      randomAssign();
    }
       // Perform slideDownRight method on each column and row correctly. Then, refreshes the grid and sets random value.
    else if(bRow == rows - 1 && bCol == columns - 1) // Slides Down and to the Right
    {
      for(int i = 0; i < rows; i++)
        slid = slide.slideDownRight(buttonValue,i,0);
      for(int j = 1; j < columns; j++)
        slid = slide.slideDownRight(buttonValue,0,j);
      setText();
      randomAssign();
    }
    else;
  } 

  /**
   * Main Method to really play the game. 
   * Initializes using conditions provided on startup.
   * @param args String parameters to main.
   */
  public static void main(String[] args)
  {
    SlideGame game;
    switch (args.length)
    {
      case 1:
      {
        try 
        {
          game = new SlideGame(Integer.parseInt(args[0]),Integer.parseInt(args[0]));
          game.setVisible(true);
        }
        catch(NumberFormatException z)
        {
          game = new SlideGame(4,4);
          game.setVisible(true);
        }
      }
      break;
      
      case 2:
      {
        try 
        {
          game = new SlideGame(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
          game.setVisible(true);
        }
        catch(NumberFormatException e)
        {
          game = new SlideGame (4,4);
          game.setVisible(true);
        }
      }
      break;
      
      default:
      {
        game = new SlideGame(4,4);
        game.setVisible(true);
        break;
      }
    }
  }
}
















































