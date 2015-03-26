package project5;

import java.util.Comparator;

/**
 * Programming Project 5
 * EECS 132
 * Represents a Contact and implements DatabaseType, 
 * so this class can be used as a type for Database.
 * @author Frank Hucek
 */
public class Contact implements DatabaseType<Contact>
{
    /**
     * The Contact's Name.
     */
    private String name;
    
    /**
     * The Contact's Phone Number.
     */
    private String phoneNumber;
    
    /**
     * The Contact's Email.
     */
    private String email;
    
    /**
     * Constructor used to create a Contact.
     * @param name 
     * @param phoneNumber
     * @param email 
     */
    public Contact(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the Contact's email.
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    /**
     * Override equals method from Object. 
     * Determines whether the two Contacts have identical information.
     * @param o an object of Object
     * @return Returns true if Contacts are equal
     */
    @Override
    public boolean equals(Object o)
    {
        Contact c = null;
        if(o.getClass() == Contact.class)
        {
            c = (Contact)o;
        }
        if(c!= null)
        {
            if(getName().equals(c.getName()) && getPhoneNumber().equals(c.getPhoneNumber())
                    && getEmail().equals(c.getEmail()))
                return true;
        }
        return false;
    }
    
    /**
     * Overrides the toString method from Object.
     * @return The name of this Contact.
     */
    @Override
    public String toString()
    {
        return this.getName();
    }
    
    /**
     * Returns a Comparator to compare 2 contacts.
     * @param trait The trait to look up in the Hashtable
     * @return Returns comparison.
     */
    @Override
    public Comparator<Contact> getComparatorByTrait(String trait)
    {
        if(trait.equals("name"))
        {
            return new Comparator<Contact>()
            {

                @Override
                public int compare(Contact o1, Contact o2) 
                {
                    return o1.getName().compareTo(o2.getName());
                }
            
            };
        }
        else if(trait.equals("phone"))
        {
            return new Comparator<Contact>()
            {

                @Override
                public int compare(Contact o1, Contact o2) 
                {
                    return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
                }
            
            };
        }
        else if(trait.equals("email"))
        {
            return new Comparator<Contact>()
            {

                @Override
                public int compare(Contact o1, Contact o2) 
                {
                    return o1.getEmail().compareTo(o2.getEmail());
                }
            
            };
        }
        else
            return null;
        // return (T o1, T o2) -> code here; Using Java lambda expression
    }
}
