package project5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Programming Project 5
 * EECS 132
 * This is a Database class.
 * It can create a database of anything that implements DatabaseType.
 * @author Frank Hucek
 * @param <T>
 */
public class Database<T extends DatabaseType> implements Iterable<T>
{

    /**
     * The node marking the start of the list of nodes.
     */
    protected LLNode<T> nodeptr;

    /**
     * The Hashtable to store the indexes.
     */
    protected Hashtable<String, ArrayList<T>> indexes = new Hashtable<String, ArrayList<T>>();

    /**
     * Default Constructor.
     */
    public Database()
    {
        this.nodeptr = null;
    }
    
    /**
     * Constructor setting the first element.
     *
     * @param firstElement
     */
    public Database(T firstElement)
    {
        this.nodeptr = new LLNode<T>(firstElement, null);
    }

    /**
     * @return the nodeptr
     */
    public LLNode<T> getNodeptr()
    {
        return nodeptr;
    }

    /**
     * @param nodeptr the nodeptr to set
     */
    public void setNodeptr(LLNode<T> nodeptr)
    {
        this.nodeptr = nodeptr;
    }
    
    /**
     * Determines whether the database is empty.
     * @return returns whether the nodeptr is null or not.
     */
    public boolean isEmpty()
    {
        return nodeptr == null;
    }

    /**
     * Adds an element into the Database.
     *
     * @param element The element to be added to the LinkedList.
     */
    public void add(T element)
    {
        setNodeptr(new LLNode<T>(element, getNodeptr()));
        indexes.clear();
    }

    /**
     * Deletes an element from the Database.
     *
     * @param element The element to be deleted from the LinkedList.
     */
    public void delete(T element)
    {
        LLNode<T> pointer = getNodeptr();
        while(pointer != null && pointer.getElement().equals(element))
        {
            setNodeptr(pointer.getNextNode());
            pointer = pointer.getNextNode();
        }
        
        while(pointer != null && pointer.getNextNode() != null)
        {

            if(pointer.getElement().equals(element) && pointer.equals(getNodeptr()))
            {  
                setNodeptr(pointer.getNextNode());
            }
            else if(pointer.getNextNode().getElement().equals(element))
            {
                pointer.setNextNode(pointer.getNextNode().getNextNode());
            }
            pointer = pointer.getNextNode();
        }
        
        indexes.clear();
    }
        
    /**
     * Looks up a value in the list of nodes and forms a LinkedList
     * with any nodes that match the input value.
     * @param value The value to be looked up.
     * @param c The comparator used to compare objects
     * @return Returns the LinkedList of nodes that match the input value.
     */
    public LinkedList<T> lookupInList(T value, Comparator<T> c)
    {
        LinkedList<T> LList = new LinkedList<T>();
        LLNode<T> pointer = nodeptr;
        while(pointer != null)
        {
            // Comparing 2 DatabaseTypes
            // If they're the same, add the pointer's element
            // to the LinkedList to return
            if(c.compare(pointer.getElement(), value) == 0) 
            {
                LList.add(pointer.getElement());
            }
            pointer = pointer.getNextNode();
        }
        return LList;
    }
    
    /**
     * 
     * @param value
     * @param index
     * @param c
     * @return 
     */
    public LinkedList<T> lookupInIndex(T value, ArrayList<T> index, Comparator<T> c)
    {
        LinkedList<T> LList = new LinkedList<T>();
        int a = Collections.binarySearch(index, value,c);
        
        for(int i = 0; i < index.size(); i++)
        {
            if(c.compare(index.get(i), value) == 0)
            {
                LList.add(index.get(i));
            }
        }
        return LList;
    }
    
    /**
     * Creates an index of the data in the database based on the input trait.
     * @param trait The trait to make an index of.
     */
    public void makeIndex(String trait)
    {
        if(nodeptr == null)
        {
        }
        else
        {
           Comparator<T> c = getNodeptr().getElement().getComparatorByTrait(trait);
           ArrayList<T> alist = new ArrayList<T>();
           
           LLNode<T> pointer = this.getNodeptr();
           
           while(pointer != null)
           {
               alist.add(pointer.getElement());
               pointer = pointer.getNextNode();
           }
           
           Collections.sort(alist,c);
           indexes.put(trait, alist);
        }
    }
    
    /**
     * Looks up a value in the Database based on the input trait and returns a LinkedList.
     * @param trait The trait used to lookup an entry.
     * @param value The entry to lookup.
     * @return Returns the LinkedList returned from anything that matches the input value.
     */
    public LinkedList<T> lookup(String trait, T value)
    {
        LinkedList<T> LList = new LinkedList<T>();
        if(getNodeptr() == null)
        {
            LList = null;
        }
        else if(indexes.contains(trait))
        {
            Comparator<T> c = value.getComparatorByTrait(trait);
            LList = this.lookupInIndex(value,indexes.get(trait),c);
        }
        else
        {
            Comparator<T> c = value.getComparatorByTrait(trait);
            LList = this.lookupInList(value,c);
        }
        return LList;
    }

    /**
     * Returns an Array List with the input trait.
     * @param trait The trait used to return an ordered ArrayList.
     * @return Returns an ordered Array List based on the trait.
     */
    public ArrayList<T> getList(String trait)
    {
       if(indexes.contains(trait))
           return indexes.get(trait);
       else
       {
           this.makeIndex(trait);
           return indexes.get(trait);
       }
    }
    
    /**
     * Returns an iterator specific to this class. 
     * @return returns an iterator.
     */
    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private LLNode<T> node = new LLNode<T>(null,getNodeptr());

            @Override
            public boolean hasNext()
            {
                return node.getNextNode() != null;
            }

            @Override
            public T next()
            {
                T element;
                if(hasNext())
                {
                    node = node.getNextNode();
                    element = node.getElement();
                }
                else
                    element = null;
                return element;
            }

            @Override
            public void remove()
            {
                node.deleteNextNode();
            } 
        };
    }
}
