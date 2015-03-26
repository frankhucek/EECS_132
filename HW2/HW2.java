/**
 * @author Frank Hucek
 * Programming Project 2
 * Due Date: 10/21/2014 A.D.
 * Working with loops
 * This class manipulates Strings to perform different tasks.
 */
public class HW2 
{
  /**
   * Used to determine whether a character is a letter. Returns true/false.
   * @param c the character to determine whether it is a letter or not.
   */
  private boolean isLetter(char c)
  {
    return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
  }
  
  /**
   * Returns true if a string is in alphabetical order, ignoring non-letters and capitalization.
   * @param s String to determine whether it is in alphabetical order.
   */
  public static boolean isAlphabeticalOrder(String s)
  {
       // Object for this class to call non-static, private method isLetter(char)
    HW2 hw2 = new HW2();
       // Represents the first Letter's index within the string
    int firstLetter = 0;
       // Represents the second Letter's index within the string
    int secondLetter = firstLetter + 1;
       /** 
        * Do this as long as secondLetter is less than the strings length
        * returns false if the character ahead is less than the character before it
        */
    while(secondLetter < s.length())
    {
         // If the secondLetter is not a letter, increment it
      if(!hw2.isLetter(s.charAt(secondLetter)))
        secondLetter = secondLetter + 1;
         // If the firstLetter is not a letter, increment it
      else if(!hw2.isLetter(s.charAt(firstLetter)))
        firstLetter = firstLetter + 1;
         // If, after incrementation, firstLetter is the same as secondLetter, increment secondLetter to be greater
      else if(firstLetter == secondLetter)
        secondLetter = secondLetter + 1;
         // If the firstLetter is greater than the secondLetter, return false, showing string not in alphabetical order
      else if(Character.toUpperCase(s.charAt(firstLetter)) > Character.toUpperCase(s.charAt(secondLetter)))
        return false;
         // Otherwise, increment both firstLetter and secondLetter
      else
      {
        firstLetter = firstLetter + 1;
        secondLetter = secondLetter + 1;
      }
    }
    return true;
  } 
  
  /** 
    * Takes a string, an int x, and a character as inputs.
    * and removes the first x occurences of the character in the string
    * @param s String to remove characters from.
    * @param numberToRemove How many of the character to remove.
    * @param letterToRemove What character to remove from the string.
    */
  public static String removeNchars(String s, int numberToRemove, char letterToRemove)
  {
       // How many letters have already been removed
    int lettersRemoved = 0;
       // index for loop
    int i = 0;
    StringBuilder builder = new StringBuilder();
       /**
        * Do this as long as the index, 'i', is less than the string's length.
        * Builds a new string using StringBuilder with the existing string,
        * ignoring letterToRemove as long as the numberToRemove has not been met.
        */
    while(i < s.length())
    {
         /**
          * If the String's character at index is the same as the letter to remove, remove it
          * as long as the lettersRemoved is not the same as the number of letters to remove.
          */
      if(s.charAt(i) == letterToRemove && lettersRemoved != numberToRemove)
      {
        i = i + 1;
        lettersRemoved++;
      }
         /** 
          * If, either lettersRemoved is the same as the numberToRemove, or 
          * the character at the index within the string is not the letterToRemove,
          * just build the new string using the characters from 's', and increment the index by 1.
          */
      else 
      {
        builder.append(s.charAt(i));
        i = i + 1;
      }
    }
    return builder.toString();
  }
  
  /** 
   * Moves 'letter' one space to the right in String s.
   * @param letter The letter to move over one space to the right in the string
   * @param s The input string to be manipulated
   */ 
  public static String moveXright(char letter, String s)
  {
       // A new StringBuilder containing empty string ""
    StringBuilder builder = new StringBuilder();
       // index for loop
    int i = 0;
       // Determines whether the letter has been moved yet.
    boolean switched = false;
       /**
        * Do as long as the index is less than the string's length.
        * Appends builder if the character at index is not the letter to switch.
        * If the index is the letter to remove, first append the character ahead of it, 
        * then append the letter on after, then, finally increment index by 2 if this is done,
        * and set switched to true.
        */
    while(i < s.length())
    {
         /**
          * If the letter has not been switched, and if the character at index is the letter,
          * switch the letter at index with the letter after it.
          */
      if(s.charAt(i) == letter && !switched && i != s.length() - 1)
      {
        builder.append(s.charAt(i + 1));
        builder.append(s.charAt(i));
        switched = true;
        i = i + 2;
      }
         /**
          * If the character at index is not the letter to move, or if switched is false,
          * just append to builder the character of the string at this index.
          */
      else
      {
        builder.append(s.charAt(i));
        i = i + 1;
      }
    }
    return builder.toString();
  }
  
  /** 
    * Puts brackets around any occurrence of the string 'part'
    * within the main string.
    * @param main This is the main String.
    * @param part This is the partial string to determine any occurrences of within main
    */
  public static String bracketString(String main, String part)
  {
       // Make a new StringBuilder with empty string, "".
    StringBuilder builder = new StringBuilder();
       // index for loop
    int i = 0;
       // Checks equivalency of letters within main and part
    boolean letterCheck = false;
       /**
        * Do as long as the index is less than the length of the main string
        * Will append to new string any letter in main from index that is not equal to
        * the first letter of part.
        * If the index letter of main is same as first letter of part,
        * checks the rest of letters. If they are the same also, 
        * append part with brackets around it to the builder.
        */
    while(i < main.length())
    {
         // Does as long as the char at index in main is same as the first letter of part
      if(main.charAt(i) == part.charAt(0))
      {    
           // new index equal to i for main.
        int index = i;
           // sets part's index to 0
        int partindex = 0;
           /**
            * Do as long as partindex is less than the length of part
            * checks whether each subsequent letter of main is the same as each letter of part.
            * If so, returns letterCheck as true, if not letterCheck is false.
            */
        while(partindex < part.length())
        {
             /** If the character at index in main is the same as the character at partindex within part, 
               * letterCheck is true
               */
          if(main.charAt(index) == part.charAt(partindex))
            letterCheck = true;
             // If the characters are not the same, set letterCheck to false.
          else 
            letterCheck = false;
             // increment partindex and index to keep scanning through strings
          partindex = partindex + 1;
          index = index + 1;
        }
           /**
            * If letterCheck is true, append part with brackets around it to new string, 
            * and add the length of part to the index, 'i'.
            */
        if(letterCheck)
        {
          builder.append("[" + part + "]");
          i = i + part.length();
        }
           // If letterCheck is not true, just add the letters at index, 'i', from main to builder.
        else 
        {
          builder.append(main.charAt(i));
          i = i + 1;
        }
      }
         // If the letters weren't the same in the first place, add letters at index from main to builder.
      else
      {
        builder.append(main.charAt(i));
        i = i + 1;
      }
    }
    return builder.toString();
  }
  
  /**
   * Moves all occurences of 'letter' one space to the right
   * within the string.
   * @param letter The letter to move each occurrence of to the right.
   * @param s The string to be manipulated
   */
  public static String moveAllXsRight(char letter, String s)
  {
       // New StringBuilder that is initialized as equal in content to string s.
    StringBuilder builder = new StringBuilder(s);
       // The index for the loop
    int i = builder.length() - 2;
       /**
        * Do as long as the index is greater or equal to 0.
        * if the character at index 'i' in s is the same as the letter to move,
        * switch it with the letter after it.
        */
    while(i >= 0)
    {
         /**
          * If the character at index in s is the letter to remove,
          * set the character in builder at the index , 'i', to the character at index + 1.
          * set the character at index + 1 to the letter that has to be moved to the right.
          * Increment the index by 1.
          */
      if(s.charAt(i) == letter )//&& i != s.length() - 1)
      {
        builder.setCharAt(i, builder.charAt(i + 1));
        builder.setCharAt(i + 1, letter);
      }
      i = i - 1;
    }
    return builder.toString();
  } 
  
  /**
   * String input contains '\n' characters, designating a new line
   * This method exchanges 'letter' with a character in the proceeding line
   * directly underneath it, only if there is a character directly underneath 'letter'.
   * @param letter The letter to move 1 space down.
   * @param s The String to be manipulated
   */
  public static String moveXdown(char letter, String s)
  {
    StringBuilder builder = new StringBuilder(s);
    
       // Position in string of letter
    int i = 0;
       
       // Find what position in s letter is at.
    for(i = 0; builder.charAt(i) != letter && i < builder.length(); i++);
     
       // Find distance starting at x to '\n' chars on either side
    int n1,n2; 
    
       // Locate n1. First occurance of '\n' to the left of letter
    for(n1 = i; builder.charAt(n1) != '\n' && n1 != 0; n1--);
    
       // Locate n2. First occurance of '\n' to the right of letter.
       // If n2 is at the end of the string, letter is in last row, so just return the string as is.
    for(n2 = i; builder.charAt(n2) != '\n' && n2 != builder.length() - 1; n2++)
    {
      if(n2 == builder.length() - 1)
        return builder.toString();
    }
       
       // Meant to locate last char or 2nd occurance of '\n' after letter. Default set to 0.
    int n3 = 0;
       
       // As long as n2 isn't the last character of the string
    if(n2 != builder.length() - 1)
         // Locate n3. 2nd occurance of '\n' to the right of letter.
      for(n3 = n2 + 1; builder.charAt(n3) != '\n' && n3 != builder.length() - 1; n3++);
      
       // Set n3 to the length of the string if it doesn't equal '\n'
    if(builder.charAt(n3) != '\n')
      n3 = builder.length();
       
       // Covers the condition where n1 is a letter and not the character, '\n'.
    if(n3 - n2 - 1 > i - n1 && n1 == 0) 
    {
      builder.setCharAt(i,builder.charAt(i + 1 + (n2 - n1)));
      builder.setCharAt((i + 1 + (n2 - n1)),letter);
      return builder.toString();
    }
       
       // Covers the condition of trying to set the character beyond total length of string.
    else if(n3 - n2 >= i - n1 && n1 != 0 && (i + (n2 - n1)) < n3)
    {
      builder.setCharAt(i,builder.charAt(i + (n2 - n1)));
      builder.setCharAt((i + (n2 - n1)),letter);
      return builder.toString();
    }
       
       // if it fails tests, return the string as is, nothing switched.
    else 
    {
      return builder.toString();
    }
  }
}
/** 
 * Frank Hucek
 */