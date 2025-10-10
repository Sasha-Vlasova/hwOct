public class ArrayCollection<T> implements CollectionInterface<T> {
    protected final int DEFCAP = 100;
    protected T[] elements; 
    protected int numElements = 0; 
   
    //Used by our find method
    protected boolean found; 
    protected int location; 
    
    
    public ArrayCollection() {
        elements = (T[]) new Object[DEFCAP];
    }

    public ArrayCollection(int capacity) {
        elements = (T[]) new Object[capacity];
    }
    protected void find(T target) {
        // Searches elements for an occurrence of an element e such that
        // e.equals(target). If successful, sets instance variables found to true
        // and location to the index of e. If not successful, sets found to false.
        location = 0;
        found = false;
        while (location < numElements) {
            if (elements[location].equals(target)) {
                found = true;
                return;
            } else {
                location++;
            }
        }
    }
    private void enlarge() {
        T[] larger = (T[]) new Object[elements.length * 2];
        for (int i = 0; i < numElements; i++) {
            larger[i] = elements[i];
        }
        elements = larger;
    }


    public boolean add(T element) {
        // Precondition: //
        // Adds element to this collection.
        if (numElements == elements.length)
            enlarge();
        find(element); // sets location to index where element belongs
        for (int index = numElements; index > location; index--)
            elements[index] = elements[index - 1];
        elements[location] = element;
        numElements++;
        return true;
    }

    public boolean remove(T target) {
        // Removes an element e from this collection such that e.equals(target)
        // and returns true; if no such element exists, returns false.
        find(target);
        if (found) {
            elements[location] = elements[numElements - 1];
            elements[numElements - 1] = null;
            numElements--;
        }
        return found;
    }
    public boolean contains(T target) {
        // Returns true if this collection contains an element e such that
        // e.equals(target); otherwise, returns false.
        find(target);
        return found;
    }
    public T get(T target) {
        // Returns an element e from this collection such that e.equals(target);
        // if no such element exists, returns null.
        find(target);
        if (found) {
            return elements[location];
        } else {
            return null;
        }
    }
    public boolean isFull() {
        // Returns true if this collection is full; otherwise, returns false.
        return (numElements == elements.length);
    }

    public boolean isEmpty() {
        // Returns true if this collection is empty; otherwise, returns false.
        return (numElements == 0);
    }

    public int size() {
        // Returns the number of elements in this collection.
        return numElements;
    }
}