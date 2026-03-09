package q2;
import java.util.List;

public class ListMinMax<T extends Comparable<T>> implements MinMax<T> {
    private List<T> list;

    public ListMinMax(List<T> list) {
        this.list = list;
    }

    public T min() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }

    
    public T max() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
