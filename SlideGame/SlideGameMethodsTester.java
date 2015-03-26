import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author Frank Hucek
 * Programming Project 3
 * Due Date: 11/7/2014 A.D.
 * SlideGameMethods JUnit Tester
 * This class tests the methods within the class SlideGameMethods
 */

public class SlideGameMethodsTester
{
     // Field creating object for class SlideGameMethods
  SlideGameMethods slide = new SlideGameMethods();
  
  /**
   * Test the slideLeft method
   */
  @Test
  public void testSlideLeft()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideLeft(input0,0));
    assertArrayEquals(expected0,input0);
       // Testing One and Last
    int[][] input1 = {{0,0,0,1},{0,1,0,0}};
    int[][] expected1 = {{1,0,0,0},{0,1,0,0}};
    assertTrue("Failed to Slide Left.", slide.slideLeft(input1,0));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{1,0,1,0},{1,0,1,0}};
    int[][] expected2 = {{1,0,1,0},{2,0,0,0}};
    assertTrue("Failed to Slide Left and combine like terms.", slide.slideLeft(input2,1));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{2,1,1,0,0},{1,0,0,0,0}};
    int[][] expected3 = {{2,2,0,0,0},{1,0,0,0,0}};
    assertTrue("Failed to Slide Left.", slide.slideLeft(input3,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{0,1,1,1,1},{0,0,0,0,0}};
    int[][] expected4 = {{2,2,0,0,0},{0,0,0,0,0}};
    assertTrue("Failed to Slide Left and combine like terms.",slide.slideLeft(input4,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{0,1,1,2,0},{0,0,0,0,0}};
    int[][] expected5 = {{4,0,0,0,0},{0,0,0,0,0}};
    assertTrue("Failed to Slide Left and combine like terms.",slide.slideLeft(input5,0));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{0,1,0,2},{0,0,0,0}};
    int[][] expected6 = {{1,2,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide Left.", slide.slideLeft(input6,0));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{1,0,0,0},{0,0,0,0}};
    int[][] expected7= {{1,0,0,0},{0,0,0,0}};
    assertFalse("Did something wrong.", slide.slideLeft(input7,0));
    assertArrayEquals(expected7,input7);
  }
  
  /*
   * Tests slideRight
   */
  @Test
  public void testSlideRight()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideRight(input0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{1,0,0,0},{0,1,0,0}};
    int[][] expected1 = {{1,0,0,0},{0,0,0,1}};
    assertTrue("Failed to Slide Right.", slide.slideRight(input1,1));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{1,0,1,0},{1,0,1,0}};
    int[][] expected2 = {{1,0,1,0},{0,0,0,2}};
    assertTrue("Failed to Slide Right and combine like terms.", slide.slideRight(input2,1));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{2,1,1,0,0},{1,0,0,0,0}};
    int[][] expected3 = {{0,0,0,0,4},{1,0,0,0,0}};
    assertTrue("Failed to Slide Right.", slide.slideRight(input3,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{0,1,1,1,1},{0,0,0,0,0}};
    int[][] expected4 = {{0,0,0,2,2},{0,0,0,0,0}};
    assertTrue("Failed to Slide Right and combine like terms.",slide.slideRight(input4,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{0,1,1,2,0},{0,0,0,0,0}};
    int[][] expected5 = {{0,0,0,2,2},{0,0,0,0,0}};
    assertTrue("Failed to Slide Right and combine like terms.",slide.slideRight(input5,0));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{0,1,0,2},{0,0,0,0}};
    int[][] expected6 = {{0,0,1,2},{0,0,0,0}};
    assertTrue("Failed to Slide Right.", slide.slideRight(input6,0));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{0,0,0,1},{0,0,0,0}};
    int[][] expected7= {{0,0,0,1},{0,0,0,0}};
    assertFalse("Did something wrong.", slide.slideRight(input7,0));
    assertArrayEquals(expected7,input7);
  }
  
   /*
   * Tests slideUp
   */
  @Test
  public void testSlideUp()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideUp(input0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{1,0,0,0},{0,0,0,0},{0,1,0,0}};
    int[][] expected1 = {{1,1,0,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide Up.", slide.slideUp(input1,1));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{1,0,0,0},{0,0,0,0},{1,0,0,0}};
    int[][] expected2 = {{2,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide Up and combine like terms.", slide.slideUp(input2,0));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{1,0,0,0,0},{1,0,0,0,0},{2,0,0,0,0}};
    int[][] expected3 = {{4,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    assertTrue("Failed to Slide Up.", slide.slideUp(input3,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{1,0,0},{1,0,0},{1,0,0},{1,0,0}};
    int[][] expected4 = {{2,0,0},{2,0,0},{0,0,0},{0,0,0}};
    assertTrue("Failed to Slide Up and combine like terms.",slide.slideUp(input4,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{2,0,0},{1,0,0},{1,0,0}};
    int[][] expected5 = {{2,0,0},{2,0,0},{0,0,0}};
    assertTrue("Failed to Slide Up and combine like terms.",slide.slideUp(input5,0));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{0,0,0},{2,0,0},{1,0,0}};
    int[][] expected6 = {{2,0,0},{1,0,0},{0,0,0}};
    assertTrue("Failed to Slide Up.", slide.slideUp(input6,0));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{1,0,0},{0,0,0},{0,0,0}};
    int[][] expected7= {{1,0,0},{0,0,0},{0,0,0}};
    assertFalse("Did something wrong.", slide.slideUp(input7,0));
    assertArrayEquals(expected7,input7);
  }
 
  /*
   * Tests slideDown
   */
  @Test
  public void testSlideDown()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideDown(input0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{1,0,0,0},{0,1,0,0},{0,0,0,0}};
    int[][] expected1 = {{1,0,0,0},{0,0,0,0},{0,1,0,0}};
    assertTrue("Failed to Slide Down.", slide.slideDown(input1,1));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{1,0,0,0},{0,0,0,0},{1,0,0,0}};
    int[][] expected2 = {{0,0,0,0},{0,0,0,0},{2,0,0,0}};
    assertTrue("Failed to Slide Down and combine like terms.", slide.slideDown(input2,0));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{1,0,0,0,0},{1,0,0,0,0},{2,0,0,0,0}};
    int[][] expected3 = {{0,0,0,0,0},{2,0,0,0,0},{2,0,0,0,0}};
    assertTrue("Failed to Slide Down.", slide.slideDown(input3,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{1,0,0},{1,0,0},{1,0,0},{1,0,0}};
    int[][] expected4 = {{0,0,0},{0,0,0},{2,0,0},{2,0,0}};
    assertTrue("Failed to Slide Down and combine like terms.",slide.slideDown(input4,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{2,0,0},{1,0,0},{1,0,0}};
    int[][] expected5 = {{0,0,0},{0,0,0},{4,0,0}};
    assertTrue("Failed to Slide Down and combine like terms.",slide.slideDown(input5,0));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{2,0,0},{0,0,0},{1,0,0}};
    int[][] expected6 = {{0,0,0},{2,0,0},{1,0,0}};
    assertTrue("Failed to Slide Down.", slide.slideDown(input6,0));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{0,0,0},{0,0,0},{0,0,1}};
    int[][] expected7= {{0,0,0},{0,0,0},{0,0,1}};
    assertFalse("Did something wrong.", slide.slideDown(input7,2));
    assertArrayEquals(expected7,input7);
  }
  
  /*
   * Tests slideUpLeft
   */
  @Test
  public void testSlideUpLeft()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideUpLeft(input0,0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{0,0,0,0},{0,0,0,0},{0,0,1,0}};
    int[][] expected1 = {{1,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide UpLeft.", slide.slideUpLeft(input1,1,1));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{0,0,0,0},{0,0,1,0},{0,0,0,1}};
    int[][] expected2 = {{0,2,0,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide UpLeft and combine like terms.", slide.slideUpLeft(input2,0,1));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{1,0,0,0,0},{0,1,0,0,0},{0,0,2,0,0}};
    int[][] expected3 = {{4,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    assertTrue("Failed to Slide UpLeft.", slide.slideUpLeft(input3,0,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
    int[][] expected4 = {{2,0,0,0},{0,2,0,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide UpLeft and combine like terms.",slide.slideUpLeft(input4,0,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{2,0,0},{0,1,0},{0,0,1}};
    int[][] expected5 = {{2,0,0},{0,2,0},{0,0,0}};
    assertTrue("Failed to Slide UpLeft and combine like terms.",slide.slideUpLeft(input5,0,0));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{1,0,0},{0,0,2},{0,0,0}};
    int[][] expected6 = {{1,2,0},{0,0,0},{0,0,0}};
    assertTrue("Failed to Slide UpLeft.", slide.slideUpLeft(input6,1,2));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{1,0,0},{0,0,0},{0,0,0}};
    int[][] expected7= {{1,0,0},{0,0,0},{0,0,0}};
    assertFalse("Did something wrong.", slide.slideUpLeft(input7,0,0));
    assertArrayEquals(expected7,input7);
  }
  
  /*
   * Tests slideDownRight
   */
  @Test
  public void testSlideDownRight()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideDownRight(input0,0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{0,0,1,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected1 = {{0,0,0,0},{0,0,0,1},{0,0,0,0}};
    assertTrue("Failed to Slide DownRight.", slide.slideDownRight(input1,0,2));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{1,0,0,0},{0,1,0,0},{0,0,0,0}};
    int[][] expected2 = {{0,0,0,0},{0,0,0,0},{0,0,2,0}};
    assertTrue("Failed to Slide DownRight and combine like terms.", slide.slideDownRight(input2,0,0));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{1,0,0,0,0},{0,1,0,0,0},{0,0,2,0,0}};
    int[][] expected3 = {{0,0,0,0,0},{0,2,0,0,0},{0,0,2,0,0}};
    assertTrue("Failed to Slide DownRight.", slide.slideDownRight(input3,0,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
    int[][] expected4 = {{0,0,0,0},{0,0,0,0},{0,0,2,0},{0,0,0,2}};
    assertTrue("Failed to Slide DownRight and combine like terms.",slide.slideDownRight(input4,0,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{2,0,0},{0,1,0},{0,0,1}};
    int[][] expected5 = {{0,0,0},{0,0,0},{0,0,4}};
    assertTrue("Failed to Slide DownRight and combine like terms.",slide.slideDownRight(input5,0,0));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{1,0,0},{0,0,2},{0,0,0}};
    int[][] expected6 = {{0,0,0},{0,0,2},{0,0,1}};
    assertTrue("Failed to Slide DownRight.", slide.slideDownRight(input6,1,1));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{0,0,0},{0,0,1},{0,0,0}};
    int[][] expected7= {{0,0,0},{0,0,1},{0,0,0}};
    assertFalse("Did something wrong.", slide.slideDownRight(input7,1,2));
    assertArrayEquals(expected7,input7);
  }

  /*
   * Tests slideUpRight
   */
  @Test
  public void testSlideUpRight()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideUpRight(input0,0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{0,0,0,0},{0,0,0,0},{1,0,0,0}};
    int[][] expected1 = {{0,0,1,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide UpRight.", slide.slideUpRight(input1,2,0));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{0,0,0,0},{0,1,0,0},{1,0,0,0}};
    int[][] expected2 = {{0,0,2,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide UpRight and combine like terms.", slide.slideUpRight(input2,1,1));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{0,0,1,0,0},{0,1,0,0,0},{2,0,0,0,0}};
    int[][] expected3 = {{0,0,4,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    assertTrue("Failed to Slide UpRight.", slide.slideUpRight(input3,2,0));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{0,0,0,1},{0,0,1,0},{0,1,0,0},{1,0,0,0}};
    int[][] expected4 = {{0,0,0,2},{0,0,2,0},{0,0,0,0},{0,0,0,0}};
    assertTrue("Failed to Slide UpRight and combine like terms.",slide.slideUpRight(input4,0,3));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{0,0,2},{0,1,0},{1,0,0}};
    int[][] expected5 = {{0,0,2},{0,2,0},{0,0,0}};
    assertTrue("Failed to Slide UpRight and combine like terms.",slide.slideUpRight(input5,1,1));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{0,0,2},{0,0,0},{1,0,0}};
    int[][] expected6 = {{0,0,2},{0,1,0},{0,0,0}};
    assertTrue("Failed to Slide UpRight.", slide.slideUpRight(input6,0,2));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{0,0,0},{0,0,1},{0,0,0}};
    int[][] expected7= {{0,0,0},{0,0,1},{0,0,0}};
    assertFalse("Did something wrong.", slide.slideUpRight(input7,1,2));
    assertArrayEquals(expected7,input7);
  }
  
  /*
   * Tests slideDownLeft
   */
  @Test
  public void testSlideDownLeft()
  {
       // Testing Zero
    int[][] input0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected0 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    assertFalse("It did something wrong.",slide.slideDownLeft(input0,0,0));
    assertArrayEquals(expected0,input0);
       // Testing One
    int[][] input1 = {{0,0,1,0},{0,0,0,0},{0,0,0,0}};
    int[][] expected1 = {{0,0,0,0},{0,0,0,0},{1,0,0,0}};
    assertTrue("Failed to Slide DownLeft.", slide.slideDownLeft(input1,0,2));
    assertArrayEquals(expected1,input1);
       // Testing Many
    int[][] input2 = {{0,0,1,0},{0,1,0,0},{0,0,0,0}};
    int[][] expected2 = {{0,0,0,0},{0,0,0,0},{2,0,0,0}};
    assertTrue("Failed to Slide DownLeft and combine like terms.", slide.slideDownLeft(input2,1,1));
    assertArrayEquals(expected2,input2);
       // Testing Many and Combines like terms
    int[][] input3 = {{0,0,0,1,0},{0,0,1,0,0},{0,2,0,0,0}};
    int[][] expected3 = {{0,0,0,0,0},{0,0,2,0,0},{0,2,0,0,0}};
    assertTrue("Failed to Slide DownLeft.", slide.slideDownLeft(input3,0,3));
    assertArrayEquals(expected3,input3);
       // Testing Many and Combines like terms correctly
    int[][] input4 =  {{0,0,0,1},{0,0,1,0},{0,1,0,0},{1,0,0,0}};
    int[][] expected4 = {{0,0,0,0},{0,0,0,0},{0,2,0,0},{2,0,0,0}};
    assertTrue("Failed to Slide DownLeft and combine like terms.",slide.slideDownLeft(input4,3,0));
    assertArrayEquals(expected4,input4);
       // Testing Many and Combines like terms correctly
    int[][] input5 = {{0,0,2},{0,1,0},{1,0,0}};
    int[][] expected5 = {{0,0,0},{0,0,0},{4,0,0}};
    assertTrue("Failed to Slide DownLeft and combine like terms.",slide.slideDownLeft(input5,0,2));
    assertArrayEquals(expected5,input5);
       // Testing Many and First
    int[][] input6 = {{0,0,1},{0,2,0},{0,0,0}};
    int[][] expected6 = {{0,0,0},{0,1,0},{2,0,0}};
    assertTrue("Failed to Slide DownLeft.", slide.slideDownLeft(input6,1,1));
    assertArrayEquals(expected6,input6);
       // Testing One and False Case
    int[][] input7 = {{0,0,0},{1,0,0},{0,0,0}};
    int[][] expected7= {{0,0,0},{1,0,0},{0,0,0}};
    assertFalse("Did something wrong.", slide.slideDownLeft(input7,1,0));
    assertArrayEquals(expected7,input7);
  }
}










