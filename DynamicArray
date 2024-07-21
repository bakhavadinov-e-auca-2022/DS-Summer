import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

    //class DynamicArray<T> implements Iterable<T>
public class DynamicArray<T> implements Iterable<T> {
    private T[] data;
    private int size;

    public DynamicArray() {
        data = (T[]) new Object[10];
        size = 0;
    }

    //public int size();
    public int size() {
        return size;
    }

    // public boolean empty();
    public boolean empty() {
        return size == 0;
    }

    //public T first();
    public T first() {
        if (empty()) throw new NoSuchElementException("DynamicArray is empty.");
        return data[0];
    }

    //public T last();
    public T last() {
        if (empty()) throw new NoSuchElementException("DynamicArray is empty.");
        return data[size - 1];
    }

    //void add(T value);
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    //T removeLast();
    public T removeLast() {
        if (empty()) throw new NoSuchElementException("DynamicArray is empty.");
        T value = data[--size];
        data[size] = null;
        return value;
    }

    //  void add(int beforePos, T value);
    public void add(int beforePos, T value) {
        if (beforePos > size || beforePos < 0) throw new IndexOutOfBoundsException("Index: " + beforePos);
        ensureCapacity(size + 1);
        System.arraycopy(data, beforePos, data, beforePos + 1, size - beforePos);
        data[beforePos] = value;
        size++;
    }

    //T remove(int pos);
    public T remove(int pos) {
        if (pos >= size || pos < 0) throw new IndexOutOfBoundsException("Index: " + pos);
        T value = data[pos];
        int moveCount = size - pos - 1;
        if (moveCount > 0) {
            System.arraycopy(data, pos + 1, data, pos, moveCount);
        }
        data[--size] = null;
        return value;
    }

    // T get(int pos);
    public T get(int pos) {
        if (pos >= size || pos < 0) throw new IndexOutOfBoundsException("Index: " + pos);
        return data[pos];
    }

    // void set(int pos, T value);
    public void set(int pos, T value) {
        if (pos >= size || pos < 0) throw new IndexOutOfBoundsException("Index: " + pos);
        data[pos] = value;
    }

    // int indexOf(T value); // returns -1 if not found
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) return i;
        }
        return -1;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            int newCapacity = data.length * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            data = Arrays.copyOf(data, newCapacity);
        }
    }



    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator(0);
    }

    public Iterator<T> begin() {
        return new DynamicArrayIterator(0);
    }

    public Iterator<T> end() {
        return new DynamicArrayIterator(size);
    }

//    public void insert(Iterator<T> it, T value) {
//        DynamicArrayIterator iterator = (DynamicArrayIterator) it;
//        add(iterator.currentIndex, value);
//    }
//
//    public void erase(Iterator<T> it) {
//        DynamicArrayIterator iterator = (DynamicArrayIterator) it;
//        remove(iterator.currentIndex);
//    }


    // class Iterator implements java.util.Iterator<T>
    private class DynamicArrayIterator implements Iterator<T> {
        private int currentIndex;

        public DynamicArrayIterator(int index) {
            this.currentIndex = index;
        }
        // public boolean hasNext();
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }


        // public T next();
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return data[currentIndex++];
        }

//        public int getCurrentIndex() {
//            return currentIndex;
//        }
    }


    // static <T> int indexOf(Iterable<T> iterable, T value);
    public static <T> int indexOf(Iterable<T> iterable, T value) {
        int index = 0;
        for (T item : iterable) {
            if ((value == null && item == null) || (value != null && value.equals(item))) {
                return index;
            }
            index++;
        }
        return -1;
    }


}
