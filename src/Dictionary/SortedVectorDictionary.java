package Dictionary.Implementations.Sorted.SortedVector;

import java.util.Vector;
import java.util.Iterator;
import Dictionary.DictionaryInterface;

/**
   A class that implements a sorted dictionary by using a vector.
   The dictionary has distinct search keys.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class SortedVectorDictionary<K extends Comparable<? super K>, V> 
             implements DictionaryInterface<K, V>
{
	private Vector<Entry> dictionary; 	

	public SortedVectorDictionary()
	{
		dictionary = new Vector<>(); // Doubles in size, as necessary
	} // end default constructor

	public SortedVectorDictionary(int initialCapacity)
	{
		dictionary = new Vector<>(initialCapacity);
	} // end constructor

   public V add(K key, V value)
	{
		V result = null;

      // Search until either you find an entry containing key or
      // you pass the point where it should be
      int keyIndex = locateIndex(key);
		
		if ( (keyIndex < dictionary.size())  && 
		     key.equals( (dictionary.get(keyIndex)).getKey() ) )
		{
   		// Key found; return and replace old value
			Entry currentEntry = dictionary.get(keyIndex);
			result = currentEntry.getValue();  // Get current value for return
			currentEntry.setValue(value);      // Replace value
		}
		else											  // Add new entry
		{ //System.out.println("adding at index = " + index);
			Entry newEntry = new Entry(key, value);
			dictionary.add(keyIndex, newEntry);
		} // end if	
		
		return result;
	} // end add

   public V remove(K key)
	{
   	V result = null;  // Return value
   	
      // search until either you find an entry containing key or
      // you pass the point where it should be
      int keyIndex = locateIndex(key);
	
		if ( (keyIndex < dictionary.size()) && 
		      key.equals( (dictionary.get(keyIndex)).getKey() ) )
		{
			Entry currentEntry = dictionary.remove(keyIndex); // Get and remove entry
			result = currentEntry.getValue();                 // Get current value for return
		} // end if

      return result;  
   } // end remove

   public V getValue(K key)
   {
      V result = null;  // Return value

      // Search until either you find an entry containing key or
      // you pass the point where it should be
      int keyIndex = locateIndex(key);
		
		if ( (keyIndex < dictionary.size()) && 
		      key.equals( (dictionary.get(keyIndex)).getKey() ) )
		{
         result = (dictionary.get(keyIndex)).getValue();
		} // end if
		
		return result;
   } // end getValue

	public boolean contains(K key)
   {
   	return getValue(key) != null; 
   } // end contains

   public boolean isEmpty()
   {
      return dictionary.isEmpty();
   } // end isEmpty
	
   public int getSize()
   {
      return dictionary.size();
   } // end getSize

 	public final void clear()
	{
		dictionary.clear();		
   } // end clear

	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	} // end getKeyIterator
	
	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	} // end getValueIterator

	// Returns the array index where the entry with a given search key is or should be.
	private int locateIndex(K key)
	{
      // Search until either you find an entry containing key or
      // you pass the point where it should be
		int numberOfEntries = dictionary.size();
		int index = 0;
		while ( (index < numberOfEntries) && 
		         key.compareTo((dictionary.get(index)).getKey()) > 0 )
		{
			index++;
		} // end while
		
		return index;
	} // end locateIndex

// Since iterators implement Iterator, methods must be public
	private class KeyIterator implements Iterator<K>
	{
		private Iterator<Entry> traverser;
		
		private KeyIterator()
		{
			traverser = dictionary.iterator();
		} // end default constructor
		
		public boolean hasNext() 
		{
			return traverser.hasNext();
		} // end hasNext
		
		public K next()
		{
			Entry nextEntry = traverser.next();
			return nextEntry.getKey();
		} // end next
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		} // end remove
	} // end KeyIterator 
	
	private class ValueIterator implements Iterator<V>
	{
		private Iterator<Entry> traverser;
		
		private ValueIterator()
		{
			traverser = dictionary.iterator();
		} // end default constructor
		
		public boolean hasNext() 
		{
			return traverser.hasNext();
		} // end hasNext
		
		public V next()
		{
			Entry nextEntry = traverser.next();
			return nextEntry.getValue();
		} // end next
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		} // end remove
	} // end ValueIterator
	
	private class Entry
	{
		private K key;
		private V value;
		
	// Since no setKey method exists, a default constructor is useless
		private Entry(K searchKey, V dataValue)
		{
			key = searchKey;
			value = dataValue;
		} // end constructor
		
		private K getKey()
		{
			return key;
		} // end getKey
		
		private V getValue()
		{
			return value;
		} // end getValue
		
		private void setValue(V dataValue)
		{
		 	value = dataValue;
		} // end setValue
	} // end Entry
} // end SortedVectorDictionary
		
