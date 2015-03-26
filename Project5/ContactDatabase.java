package project5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Programming Project 5
 * EECS 132
 * A Database containing Contacts.
 * @author Frank Hucek
 */
public class ContactDatabase extends Database<Contact>
{
    /**
     * Prints a list of each Contact in the list.
     * @param it
     */
    public void printList(Iterable<Contact> it)
    {
        int i = 1;
        for(Contact c:it)
        {
            System.out.println(i + ". " + c.getName() + " " 
                    + c.getPhoneNumber()+ " " + c.getEmail());
            i++;
        }
    }
    
    /**
     * Main method to be used by the user.
     * @param args The command line input at run time.
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ContactDatabase database = new ContactDatabase();
        List<Contact> recentList = null;
        
        String input = "";
        
        do
        {
            System.out.println("Please enter your input. Type \"options\" for help.");
            input = scanner.next();
            
            if (input.equalsIgnoreCase("add"))
            {
                String name, phoneNumber, email;
                name = scanner.next();
                phoneNumber = scanner.next();
                email = scanner.next();
                database.add(new Contact(name, phoneNumber, email));
            } 
            else if (input.equalsIgnoreCase("listby"))
            {
                String trait = scanner.next();
                if (!database.isEmpty())
                {
                    if (trait.equalsIgnoreCase("name")
                            || trait.equalsIgnoreCase("phone")
                            || trait.equalsIgnoreCase("email"))
                    {
                        ArrayList<Contact> alist = database.getList(trait);
                        database.printList(alist);
                        recentList = alist;
                    } 
                    else
                    {
                        System.out.println("Invalid input");
                    }
                } 
                else // Database is empty
                {
                    System.out.println("Can't list an empty list.");
                }
            }
            else if(input.equalsIgnoreCase("find"))
            {
                String trait = scanner.next();
                String traitValue = scanner.next();
                if(trait.equalsIgnoreCase("name"))
                {
                    LinkedList<Contact> LList 
                            = database.lookup(trait,new Contact(traitValue, null, null));
                    database.printList(LList);
                    recentList = LList;
                }
                else if(trait.equalsIgnoreCase("phone"))
                {
                    LinkedList<Contact> LList 
                            = database.lookup(trait,new Contact(null, traitValue, null));
                    database.printList(LList);
                    recentList = LList;
                }
                else if(trait.equalsIgnoreCase("email"))
                {
                    LinkedList<Contact> LList 
                            = database.lookup(trait,new Contact(null, null, traitValue));
                    database.printList(LList);
                    recentList = LList;
                }
                else
                {
                    System.out.println("Invalid input.");
                }
            }
            else if(input.equalsIgnoreCase("delete"))
            {
                String index = scanner.next();
                int i = Integer.parseInt(index);
                if(i >= 1)
                {
                    try
                    {
                        Contact c = recentList.get(i - 1);
                        database.delete(c);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Invalid input.");
                    }
                }
                else
                    System.out.println("Invalid input.");
            }
            else if(input.equalsIgnoreCase("makeindex"))
            {
                String trait = scanner.next();
                database.makeIndex(trait);
            }
            else if(input.equalsIgnoreCase("options"))
            {
                System.out.println("Type \"add\" followed by a name, "
                        + "phone number, and email to add a contact to the database.");
                System.out.println("Type \"listby\" followed by either \"name\","
                        + " \"phone\", or \"email\" to get a listing by the given trait.");
                System.out.println("Type \"find\" followed by \"name\","
                        + " \"phone\", or \"email\" followed by a specific value of your given trait"
                        + " to lookup anyone in the data base with that trait.");
                System.out.println("Type \"delete\" followed by a number from the last"
                        + " \"listby\" you entered to delete the contact at that number in the list.");
                System.out.println("Type \"makeindex\" followed by a specific trait "
                        + "to create an index for the contact based on that trait. "
                        + "This is mainly for speedy searches.");
                System.out.println("Type \"quit\" to exit the program.");
            }
            else
                System.out.println();
            
        }while(!input.equals("quit"));
        scanner.close();
    }
}































