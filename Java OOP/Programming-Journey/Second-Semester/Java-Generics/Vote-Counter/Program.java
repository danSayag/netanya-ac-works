package q2;
import java.util.ArrayList;
import java.util.List;

public class Program{
public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(10);
        numbers.add(1);
        numbers.add(7);

        ListMinMax<Integer> listMinMax = new ListMinMax<>(numbers);
        Integer min = listMinMax.min();
        Integer max = listMinMax.max();

        System.out.println("Min: " + min);
        System.out.println("max: " + max);
    }
}