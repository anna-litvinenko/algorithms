package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Anna on 2/6/17.
 */
public class RemoveDuplicates {

    /**
     * remove duplicates from the sorted array in place
     * @return new length
     */
    static int removeDupSorted(int[] array) {
        Objects.requireNonNull(array, "Array must not be null");
        if (array.length == 0) {
            return 0;
        }
        int write = 0;
        for (int read = 1; read < array.length; read++) {
            if (array[write] != array[read]) {
                write++;
                array[write] = array[read];
            }
        }
        return write + 1;
    }

    /**
     * find array's length
     * @return new length
     */
    static int findArrayLength(int[] array) {
        int first = 0;
        int count = 0;
        for (int second = 1; second < array.length; second++) {
            if (array[first] != array[second]) {
                first = second;
                count++;
            }
        }
        return count + 1;
    }

    /**
     * remove duplicates from the sorted array
     * @return the new array
     */
    static int[] removeDupNewArray(int[] array) {
        Objects.requireNonNull(array, "Array must not be null");
        if (array.length == 0) {
           return array;
        }
        int length = findArrayLength(array);
        int[] newArray = new int[length];
        newArray[0] = array[0];
        int write = 0;
        for (int read = 1; read < array.length; read++) {
            if (newArray[write] != array[read]) {
                write++;
                newArray[write] = array[read];
            }
        }
        return newArray;
    }

    /**
     * check if the array contains the given element
     */
    static boolean containsElement(int[] array, int from, int to, int element) {
        int i = from;
        int j = to;
        while (i<j) {
            if (array[i] == element) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * remove duplicates from the unsorted array with brute force in place
     * @return the new length
     */
    static int removeDupUnsortedBruteForse(int[] array) {
        Objects.requireNonNull(array, "Array must not be null");
        if (array.length == 0) {
            return 0;
        }
        int write = 0;
        for (int read = 1; read < array.length; read++) {
            if (!containsElement(array, 0, read, array[read])) {
                write++;
                array[write] = array[read];
            }
        }
        return write + 1;
    }

    /**
     * remove duplicates from the unsorted array in place using Set
     * @return the new length
     */
    static int removeDupUnsortedSet(int[] array) {
        Objects.requireNonNull(array, "Array must not be null");
        if (array.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        int i = 0;
        for (int element : set) {
            array[i] = element;
            i++;
        }
        return i;
    }

    /**
     * remove duplicates from the unsorted array using Set
     * @return new array
     */
    static int[] removeDupUnsortedSetNewArray(int[] array) {
        Objects.requireNonNull(array, "Array must not be null");
        if (array.length == 0) {
            return array;
        }
        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        int[] newArray = new int[set.size()];
        int i = 0;
        for (int element : set) {
            newArray[i] = element;
            i++;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = removeDupUnsortedSetNewArray(new int[] {1});
        System.out.println(Arrays.toString(array));

    }
}
