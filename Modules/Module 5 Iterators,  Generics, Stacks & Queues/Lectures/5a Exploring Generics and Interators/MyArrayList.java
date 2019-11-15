/* 
   This class which represents a generic version of ArrayIntList
   now warns us of an "unchecked or unsafe operation".
   You can read about that mess here: 
   https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
   But we're going to ignore the warning.
*/


import java.util.*;

public class MyArrayList<E> {
    private E[] data; // array of integers
    private int size;   // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 3;

    // post: constructs an empty list of default capacity
    public MyArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + data[0];
            for (int i = 1; i < size; i++) {
                result += ", " + data[i];
            }
            result += "]";
            return result;
        }
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(E value) {
        checkCapacity(size + 1);
        data[size] = value;
        size++;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public E get(int index) {
        checkIndex(index);
        return (E)data[index];
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        checkCapacity(size + 1);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    // post: checks that the underlying array has the given capacity,
    //       expanding the size if it does not
    private void checkCapacity(int capacity) {
        if (capacity > data.length) {
            //throw new IllegalStateException("would exceed list capacity");
            expandSize();
        }
    }

   private void expandSize() {
      int increasedSize = data.length * 2;
      data = Arrays.copyOf(data, increasedSize);
   }
}