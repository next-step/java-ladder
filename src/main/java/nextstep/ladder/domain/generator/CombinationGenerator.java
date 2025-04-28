package nextstep.ladder.domain.generator;

import java.util.*;

public class CombinationGenerator {
    public static void main(String[] args) {
        int countOfPerson = 3;
        List<List<Boolean>> result = new ArrayList<>();
        generateCombinations(countOfPerson, new ArrayList<>(), result);

        for (List<Boolean> combination : result) {
            if(hasConsecutiveTrues(combination)) {
                System.out.println(combination);
            }
        }
    }

    public static void generateCombinations(int n, List<Boolean> current, List<List<Boolean>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(true);
        generateCombinations(n, current, result);
        current.remove(current.size() - 1);

        current.add(false);
        generateCombinations(n, current, result);
        current.remove(current.size() - 1);
    }

    private static boolean hasConsecutiveTrues(List<Boolean> combination) {
        for (int i = 0; i < combination.size() - 1; i++) {
            if (combination.get(i) && combination.get(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
