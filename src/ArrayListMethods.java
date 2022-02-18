import java.util.Comparator;

public interface ArrayListMethods <T> {
    void sort(Comparator<T> comparator);
    boolean isEmpty();
    void add(T item);
    void add(int index, T item);
    int size();
    void delete(int index);
    int index(T item);
    T get(int index);
    void set(int index, T item);
}