import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> implements ArrayListMethods<T>{
    private T[] items;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int arraySize = DEFAULT_CAPACITY;

    /**
     * arraylist conctructor
     */
    public MyArrayList(){
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     *
     * @param comparator implementation of comparator to sort arrays
     */
    @Override
    public void sort(Comparator<T> comparator) {
        quickSort(comparator, 0, size - 1);
    }

    /**
     *
     * @return checking if created list is empty, return false if dont
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param item adding element to arraylist , places it to last index
     */
    @Override
    public void add(T item) {
        resize();
        items[size] = item;
        size++;
    }

    /**
     * @param index write index for adding element to direct add
     * @param item element to add
     */

    @Override
    public void add(int index, T item) {
        resize();
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        ++size;

    }

    /**
     *
     * @return method to know what size is your list atm
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @param index deleting element from choosed index
     */
    @Override
    public void delete(int index) {
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[--size] = null;
        resize();

    }

    /**
     *
     * @param item put element that you want to know its index
     * @return returning index of element
     */

    @Override
    public int index(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(items[i]))
                return i;
        }
        return -1;
    }

    /**
     *
     * @param index write index and get element which is under that index
     * @return
     */
    @Override
    public T get(int index) {
        return items[index];
    }

    /**
     *
     * @param index setting new index for existing element
     * @param item exact element
     */
    @Override
    public void set(int index, T item) {
        items[index] = item;

    }

    /**
     *
     * @return printing out whole array to string
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(items, size));
    }

    /**
     * quicksort elements in array
     * @param comparator for sorting elemenets in array
     * @param lowIndex choosing left pointer to go thru array
     * @param highIndex choosing right pointer to go thru array
     */
    private void quickSort(Comparator<T> comparator, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        T pivot = items[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (comparator.compare(items[leftPointer], pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (comparator.compare(items[rightPointer], pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(leftPointer, rightPointer);
        }
        swap(leftPointer, highIndex);
        quickSort(comparator, lowIndex, leftPointer - 1);
        quickSort(comparator, leftPointer + 1, highIndex);
    }

    /**
     *  swapping indexes for continuing sorting
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    /**
     * resize of array after deleting or adding elements
     */
    private void resize() {
        if (size >= arraySize) {
            Object[] newValues = new Object[size * 3 / 2 + 1];
            System.arraycopy(items, 0, newValues, 0, size);
            items = (T[]) newValues;
        }
        if (size >= DEFAULT_CAPACITY && size < arraySize / 4) {
            Object[] newValues = new Object[size * 3 / 2 + 1];
            System.arraycopy(items, 0, newValues, 0, size);
            items = (T[]) newValues;
        }
    }
}