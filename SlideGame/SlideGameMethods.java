/**
 * @author Frank Hucek
 * Programming Project 3
 * Due Date: 11/7/2014 A.D.
 * SlideGameMethods class
 * This class contains the algorithms for the SlideGame
 */

public class SlideGameMethods
{
     // Field to determine whether an element was moved in a method
  private boolean moved = false;
     // Field to represent the diagonal row
  private int diagrow;
     // Field to represent the diagonal column
  private int diagcol;
     // Private method to shift all elements of an array to the left
  private void shiftLeft(int[] array)
  {
    int j = 1;
       // As long as j < array's length, and if array[j] is not 0, and array[j - 1] is 0, switch the 2 values, and reset index
    while(j < array.length)
    {
      if(array[j] != 0 && array[j - 1] == 0)
      {
        int temp;
        temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
        this.moved = true;
        j = 1;
      }
      else
        j++;
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers to the left.
   * @param array The array to be manipulated
   * @param row The array's row to be sorted
   * @return moved Returns whether an element was moved
   */ 
  
  public boolean slideLeft(int[][] array, int row)
  {
    this.moved = false;
    shiftLeft(array[row]);
    int i = 0;
       // While index < the array of the given row's length, combine any terms that are the same and shift to the left
    while(i < array[row].length - 1)
    {
      if(array[row][i] == array[row][i + 1] && array[row][i] != 0)
      {
        array[row][i] = array[row][i] + array[row][i + 1];
        array[row][i + 1] = 0;
        shiftLeft(array[row]);
        this.moved = true;
      }
      else 
        i++;
    }
    shiftLeft(array[row]);
    return moved;
  }
  
     // Private method to shift all elements of an array to the right
  private void shiftRight(int[] array)
  {
    int j = array.length - 1;
       // While j > 0, shift anything that is nonzero to the left
    while(j > 0)
    {
      if(array[j] == 0 && array[j - 1] != 0)
      {
        int temp;
        temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
        this.moved = true;
        j = array.length - 1;
      }
      else
        j--;
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers to the right.
   * @param array The array to be manipulated
   * @param row The array's row to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideRight(int[][] array, int row)
  {
    this.moved = false;
    shiftRight(array[row]);
    int i = array[row].length - 1;
       // While the index > 0, combine like terms and shift nonzeroes to the right if combining occurs.
    while(i > 0)
    {
      if(array[row][i] == array[row][i - 1] && array[row][i] != 0)
      {
        array[row][i] = array[row][i] + array[row][i - 1];
        array[row][i - 1] = 0;
        shiftRight(array[row]);
        this.moved = true;
      }
      else 
        i--;
    }
    shiftRight(array[row]);
    return moved;
  }
  
     // Private method to shift nonzero elements of a 2D array up.
  private void shiftUp(int[][] array, int col)
  {
    int i = 1;
       // While the index < array's length, shift any nonzero elements upwards.
    while(i < array.length)
    {
      if(array[i][col] != 0 && array[i - 1][col] == 0) 
      {
        int temp;
        temp = array[i][col];
        array[i][col] = array[i - 1][col];
        array[i - 1][col] = temp;
        this.moved = true;
        i = 1;
      }
      else
        i++;
    }
  }
  /**
   * Combines consecutive like terms while shifting all nonzero numbers upwards.
   * @param array The array to be manipulated
   * @param col The array's column to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideUp(int[][] array, int col)
  {
    this.moved = false;
    shiftUp(array, col);
    int i = 0;
       // While the index < arrays length - 1, combine like terms. If this happens, do a shift up.
    while(i < array.length - 1)
    {
      if(array[i][col] == array[i + 1][col] && array[i][col] != 0)
      {
        array[i][col] = array[i][col] + array[i + 1][col];
        array[i + 1][col] = 0;
        shiftUp(array, col);
        this.moved = true;
      }
      else 
        i++;
    }
    shiftUp(array, col);
    return moved;
  }
     
     // Private method to shift nonzero elements of a 2D array downwards.
  private void shiftDown(int[][] array, int col)
  {
    int i = array.length - 1;
       // While the index > 0, shift all the nonzero elements down.
    while(i > 0)
    {
      if(array[i][col] == 0 && array[i - 1][col] != 0)
      {
        int temp;
        temp = array[i][col];
        array[i][col] = array[i - 1][col];
        array[i - 1][col] = temp;
        this.moved = true;
        i = array.length - 1;
      }
      else
        i--;
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers downwards.
   * @param array The array to be manipulated
   * @param col The array's column to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideDown(int[][] array, int col)
  {
    this.moved = false;
    shiftDown(array, col);
    int i = array.length - 1;
       // While the index > 0, combine like terms. If this happens, shift numbers down.
    while(i > 0)
    {
      if(array[i][col] == array[i - 1][col] && array[i][col] != 0)
      {
        array[i][col] = array[i][col] + array[i - 1][col];
        array[i - 1][col] = 0;
        shiftDown(array, col);
        this.moved = true;
      }
      else 
        i--;
    }
    shiftDown(array, col);
    return moved;
  }
  
     // array[row][col]
     // Private method to take a 2D array, and shift all nonzero elements up and to the left of the diagonal that contains row and col
  private void shiftUpLeft(int[][] array, int row, int col)
  {
      // Finding row start and column start for element @ row and col
    while(col > 0 && row > 0)
    {
      row--;
      col--;
    }
    this.diagrow = row;
    this.diagcol = col;
       // Shifts all nonzero elements up and to the left along it's diagonal.
    while(row < array.length - 1 && col < array[row].length - 1)
    {
      if(array[row][col] == 0 && array[row + 1][col + 1] != 0)
      {
        int temp;
        temp = array[row][col];
        array[row][col] = array[row + 1][col + 1];
        array[row + 1][col + 1] = temp;
        this.moved = true;
        row = this.diagrow;
        col = this.diagcol;
      }
      else
      {
        row++;
        col++;
      }
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers in a 2D array up and to the Left.
   * @param array The array to be manipulated
   * @param row The array's row to be sorted
   * @param col The array's column to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideUpLeft(int[][] array, int row, int col)
  {
    this.moved = false;
    shiftUpLeft(array, row, col);
    int i = this.diagrow;
    int j = this.diagcol;
       // Combine like terms along the diagonal. If this happens, shift elements up and to the left.
    while(i < array.length -1 && j < array[row].length - 1)
    {
      if(array[i][j] == array[i + 1][j + 1] && array[i][j] != 0)
      {
        array[i][j] = array[i][j] + array[i + 1][j + 1];
        array[i + 1][j + 1] = 0;
        shiftUpLeft(array,row,col);
        this.moved = true;
      }
      else
      {
        i++;
        j++;
      }
    }
    shiftUpLeft(array,row,col);
    return moved;
  }
  
     // Private method to shift nonzero elements of a 2D array down and to the right of the diagonal of row and col
  private void shiftDownRight(int[][] array, int row, int col)
  {
       // Finding row start and column start for element @ row and col
    while(col != array[row].length - 1 && row != array.length - 1)
    {
      row++;
      col++;
    }
    this.diagrow = row;
    this.diagcol = col;
       // Shift all nonzero elements down and to the right within the 2D array
    while(row > 0 && col > 0)
    {
      if(array[row][col] == 0 && array[row - 1][col - 1] != 0)
      {
        int temp;
        temp = array[row][col];
        array[row][col] = array[row - 1][col - 1];
        array[row - 1][col - 1] = temp;
        this.moved = true;
        row = this.diagrow;
        col = this.diagcol;
      }
      else
      {
        row--;
        col--;
      }
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers in a 2D array Down and to the Right.
   * @param array The array to be manipulated
   * @param row The array's row to be sorted
   * @param col The array's column to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideDownRight(int[][] array, int row, int col)
  {
    this.moved = false;
    shiftDownRight(array, row, col);
    int i = this.diagrow;
    int j = this.diagcol;
      // Combines like terms along diagonal. If this happens, shifts all nonzero elements Down and to the Right.
    while(i > 0 && j > 0)
    {
      if(array[i][j] == array[i - 1][j - 1] && array[i][j] != 0)
      {
        array[i][j] = array[i][j] + array[i - 1][j - 1];
        array[i - 1][j - 1] = 0;
        shiftDownRight(array,row,col);
        this.moved = true;
      }
      else
      {
        i--;
        j--;
      }
    }
    shiftDownRight(array,row,col);
    return moved;
  }
  
     // Private method to shift nonzero elements of 2D array Up and to the Right on the diagonal of row and col
  private void shiftUpRight(int[][] array, int row, int col)
  {
       // Finding row start and column start for element @ row and col
    while(col != array[row].length - 1 && row > 0)
    {
      row--;
      col++;
    }
    this.diagrow = row;
    this.diagcol = col;
       // Shifts nonzero elements of array up and to the right on respective diagonal.
    while(row < array.length - 1 && col > 0)
    {
      if(array[row][col] == 0 && array[row + 1][col - 1] != 0)
      {
        int temp;
        temp = array[row][col];
        array[row][col] = array[row + 1][col - 1];
        array[row + 1][col - 1] = temp;
        this.moved = true;
        row = this.diagrow;
        col = this.diagcol;
      }
      else
      {
        row++;
        col--;
      }
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers in a 2D array Up and to the Right.
   * @param array The array to be manipulated
   * @param row The array's row to be sorted
   * @param col The array's column to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideUpRight(int[][] array, int row, int col)
  {
    this.moved = false;
    shiftUpRight(array, row, col);
    int i = this.diagrow;
    int j = this.diagcol;
       // Combines like terms along diagonal. If this happens, shifts all nonzero elements Up and to the Right.
    while(i < array.length - 1 && j > 0)
    {
      if(array[i][j] == array[i + 1][j - 1] && array[i][j] != 0)
      {
        array[i][j] = array[i][j] + array[i + 1][j - 1];
        array[i + 1][j - 1] = 0;
        shiftUpRight(array,row,col);
        this.moved = true;
      }
      else
      {
        i++;
        j--;
      }
    }
    shiftUpRight(array,row,col);
    return moved; 
  }
     // Private method to shift nonzero elements of 2D array Down and to the Left along diagonal of row and col
  public void shiftDownLeft(int[][] array, int row, int col)
  {
       // Finding row start and column start for element @ row and col
    while(col > 0 && row != array.length - 1)
    {
      row++;
      col--;
    }
    this.diagrow = row;
    this.diagcol = col;
       // Shifts nonzero elements of array Down and to the Left of respective diagonal
    while(row > 0 && col < array[row].length - 1)
    {
      if(array[row][col] == 0 && array[row - 1][col + 1] != 0)
      {
        int temp;
        temp = array[row][col];
        array[row][col] = array[row - 1][col + 1];
        array[row - 1][col + 1] = temp;
        this.moved = true;
        row = this.diagrow;
        col = this.diagcol;
      }
      else
      {
        row--;
        col++;
      }
    }
  }
  
  /**
   * Combines consecutive like terms while shifting all nonzero numbers in a 2D array Down and to the Left.
   * @param array The array to be manipulated
   * @param row The array's row to be sorted
   * @param col The array's column to be sorted
   * @return moved Returns whether an element was moved
   */ 
  public boolean slideDownLeft(int[][] array, int row, int col)
  {
    this.moved = false;
    shiftDownLeft(array, row, col);
    int i = this.diagrow;
    int j = this.diagcol;
       // Combines like terms along diagonal. If this happens, shifts all nonzero elements Up and to the Right.
    while(j < array[row].length - 1 && i > 0)
    {
      if(array[i][j] == array[i - 1][j + 1] && array[i][j] != 0)
      {
        array[i][j] = array[i][j] + array[i - 1][j + 1];
        array[i - 1][j + 1] = 0;
        shiftDownLeft(array,row,col);
        this.moved = true;
      }
      else
      {
        i--;
        j++;
      }
    }
    shiftDownLeft(array,row,col);
    return moved; 
  }
}








