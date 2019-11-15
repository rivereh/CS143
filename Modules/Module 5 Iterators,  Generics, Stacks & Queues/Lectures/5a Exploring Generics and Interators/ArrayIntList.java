public class ArrayIntList { // implements IntList {
    private int[] data; // array of integers
    private int size;   // current number of elements in the list

    public static final int CAPACITY = 20;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        data = new int[CAPACITY];
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
    public void add(int value) {
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
    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
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
    public void add(int index, int value) {
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
    //       throwing an IllegalStateException if it does not
    private void checkCapacity(int capacity) {
        if (capacity > data.length) {
            throw new IllegalStateException("would exceed list capacity");
        }
    }
}