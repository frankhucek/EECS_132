package project5;

import java.util.*;

/**
 * Programming Project 5
 * EECS 132
 * Anything that implements this can be used as a type within the Database class.
 * @author Frank Hucek
 * @param <T> Generic type.
 */

public interface DatabaseType<T>
{
    /**
     * Returns the Comparator based on the specific input trait.
     * @param trait The trait to compare by.
     * @return An object of Comparator that can compare based on the given trait.
     */
    public Comparator<T> getComparatorByTrait(String trait);
}
