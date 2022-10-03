package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomUtils {
    public static List<Integer> getRandomNumbers(int size, int start, int end) {
        return getUniqueNumbers(size, start, end);
    }

    private static List<Integer> getUniqueNumbers(int size, int start, int end) {
        HashSet<Integer> checkNumbers = new HashSet<>();
        while (checkNumbers.size() < size) {
            checkNumbers.add(Randoms.pickNumberInRange(start, end));
        }
        return new ArrayList<>(checkNumbers);
    }
}
