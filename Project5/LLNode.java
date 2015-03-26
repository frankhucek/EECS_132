package project5;

/**
 * Programming Project 5
 * EECS 132
 * A simple LLNode class.
 * @author Frank Hucek
 * @param <T> Generic type.
 */
public class LLNode<T>
{
    /**
     * The element of a node.
     */
    private T element;
    
    /**
     * The next node of this node.
     */
    private LLNode<T> nextNode;
    
    /**
     * Constructor setting this node's element and next node.
     * @param element This node's element.
     * @param nextNode The next node.
     */
    public LLNode(T element, LLNode<T> nextNode)
    {
        this.element =  element;
        this.nextNode = nextNode;
    }

    /**
     * @return the element
     */
    public T getElement() 
    {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) 
    {
        this.element = element;
    }

    /**
     * @return the nextNode
     */
    public LLNode<T> getNextNode() 
    {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(LLNode<T> nextNode) 
    {
        this.nextNode = nextNode;
    }
    
  /**
   * Remove the node that occurs immediately after this node in the list.
   */
  public void deleteNextNode() 
  {
    if (this.getNextNode() != null)
    { 
      this.setNextNode(this.getNextNode().getNextNode());
    }
  }
  
  /**
   * Returns the length from this node to the end of the list of nodes.
   * @return A value of type int.
   */
  public int lengthFromHere()
  {
     if(getNextNode() == null)
         return 0;
     else
         return 1 + getNextNode().lengthFromHere();
  }
}
