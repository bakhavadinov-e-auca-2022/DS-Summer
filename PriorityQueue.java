import java.util.ArrayList;
import java.util.List;

// class PriorityQueue<T extends Comparable<T>>
public class PriorityQueue<T extends Comparable<T>> {

    // private List<T> values;
    private List<T> values;

    public PriorityQueue() {
        this.values = new ArrayList<>();
    }

    // private void up(int pos);
    private void up(int pos) {
        while (pos > 0) {
            int parent = (pos - 1) / 2;
            if (values.get(pos).compareTo(values.get(parent)) >= 0) {
                break;
            }
            swap(pos, parent);
            pos = parent;
        }
    }

    // private void down(int pos);
    private void down(int pos) {
        int size = values.size();
        while (2 * pos + 1 < size) {
            int leftChild = 2 * pos + 1;
            int rightChild = leftChild + 1;
            int smallest = leftChild;
            if (rightChild < size && values.get(rightChild).compareTo(values.get(leftChild)) < 0) {
                smallest = rightChild;
            }
            if (values.get(pos).compareTo(values.get(smallest)) <= 0) {
                break;
            }
            swap(pos, smallest);
            pos = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }

    //public int size();
    public int size() {
        return values.size();
    }

    // public T peek(); // returns min element
    public T peek() {
        return values.isEmpty() ? null : values.get(0);
    }

    // public T poll(); // removes min element
    public T poll() {
        if (values.isEmpty()) {
            return null;
        }
        T result = values.get(0);
        T lastValue = values.remove(values.size() - 1);
        if (!values.isEmpty()) {
            values.set(0, lastValue);
            down(0);
        }
        return result;
    }

    //  public void add(T value); // inserts element into queue
    public void add(T value) {
        values.add(value);
        up(values.size() - 1);
    }
}
