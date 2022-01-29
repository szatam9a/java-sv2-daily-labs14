package day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PairFinder {
    private int allPairs;

    public int findPairs(int[] arr) {
        allPairs = 0;
        Map<Integer, Boolean> pairs = new TreeMap<>();
        Arrays.stream(arr).forEach(e -> countME(e, pairs));
        return allPairs;
    }

    private void countME(Integer theNumber, Map<Integer, Boolean> map) {
        if (map.containsKey(theNumber)) {
            if (map.get(theNumber).equals(true)) {
                map.replace(theNumber, false);
                allPairs++;
            } else
                map.replace(theNumber, true);
        } else {
            map.put(theNumber, true
            );
        }
    }

    public static void main(String[] args) {
        PairFinder pairFinder = new PairFinder();
        int[] toTest = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        System.out.println(pairFinder.findPairs(toTest));
    }
}
