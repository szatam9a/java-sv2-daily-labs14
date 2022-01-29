package day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PairFinder {
    private int allPairs;

    public int findPairs(int[] arr) {
        allPairs = 0;
        Map<Integer, Integer> pairs = new TreeMap<>();
        Arrays.stream(arr).forEach(e -> countME(e, pairs));
        return allPairs;
    }

    private void countME(Integer theNumber, Map<Integer, Integer> map) {
        if (map.containsKey(theNumber)) {
            if (map.get(theNumber).equals(1)) {
                map.replace(theNumber, 0);
                allPairs++;
            } else
                map.replace(theNumber, 1);
        } else {
            map.put(theNumber, 1);
        }
    }

    public static void main(String[] args) {
        PairFinder pairFinder = new PairFinder();
        int[] toTest = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        System.out.println(pairFinder.findPairs(toTest));
    }
}
