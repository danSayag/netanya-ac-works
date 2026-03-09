package q3;
import java.util.*;

public class Program {
    public static <T> Map<T, Integer> calcFreq(Collection<T> collection) {
        Map<T, Integer> frequencyMap = new HashMap<>();
        for (T item : collection) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 3, 4, 4, 4, 4);
        Map<Integer, Integer> freqMap = calcFreq(list);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-----------------");

        List<String> stringList = Arrays.asList("a", "b", "b", "c", "c", "c", "d", "d", "d", "d");
        Map<String, Integer> stringFreqMap = calcFreq(stringList);
        for (Map.Entry<String, Integer> entry : stringFreqMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
