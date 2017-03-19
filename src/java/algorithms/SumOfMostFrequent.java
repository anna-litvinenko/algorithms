package algorithms;

import java.util.*;

/**
 * Created by Anna on 2/14/17.
 */
public class SumOfMostFrequent {

    /**
     * find the sum of k-most frequent element
     */
    static Optional<Integer> SumOfMostFrequentElement(int[] array, int k) {
        Objects.requireNonNull(array, "Array must not be null");
        Map<Integer, Integer> counts = new HashMap<>();
        for (int element : array) {
            if (!counts.containsKey(element)) {
                counts.put(element, 0);
            }
            counts.put(element, counts.get(element) + 1);
        }
        if (counts.size() == array.length) {
            return Optional.empty();
        }
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            frequency.put(entry.getValue(), entry.getKey());
        }
        if (frequency.size() < k) {
            return Optional.empty();
        }
        for (int i = 0; i < k - 1; i++) {
            frequency.remove(frequency.lastKey());
        }
        int kfrequency = frequency.lastKey();
        int sum = kfrequency * frequency.get(kfrequency);
        return Optional.of(sum);
    }

    /**
     * find the sum of k-most frequent element. If there are a few elements, count for the smaller
     */
    static Optional<Integer> SumOfMostFrequentElementSmaller(int[] array, int k) {
        Objects.requireNonNull(array, "Array must not be null");
        Map<Integer, Integer> counts = new HashMap<>();
        for (int element : array) {
            if (!counts.containsKey(element)) {
                counts.put(element, 0);
            }
            counts.put(element, counts.get(element) + 1);
        }
        if (counts.size() == array.length) {
            return Optional.empty();
        }
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (!frequency.containsKey(entry.getValue()) || entry.getKey() < frequency.get(entry.getValue())) {
                frequency.put(entry.getValue(), entry.getKey());
            }
        }
        if (frequency.size() < k) {
            return Optional.empty();
        }
        for (int i = 0; i < k - 1; i++) {
            frequency.remove(frequency.lastKey());
        }
        int kfrequency = frequency.lastKey();
        int sum = kfrequency * frequency.get(kfrequency);
        return Optional.of(sum);
    }

    public void abc() {
        String s = "";
        for (char c : s.toCharArray()) {

        }
    }

    public static void main(String[] args) {
        System.out.println(SumOfMostFrequentElementSmaller(new int [] {1,1,2,2,3,3,4}, 1));

    }

}


