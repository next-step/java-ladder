package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public List<Boolean> generate(int n) {
        List<Boolean> combination = new ArrayList<>(Collections.nCopies(n, false));
        generateNonAdjacentCombination(n).forEach(index -> combination.set(index, true));
        return combination;
    }

    private static List<Integer> generateNonAdjacentCombination(int n) {
        List<List<Integer>> AllNonAdjacentCombinations = generateAllNonAdjacentCombinations(n);
        return AllNonAdjacentCombinations.get(new Random().nextInt(AllNonAdjacentCombinations.size()));
    }

    private static List<List<Integer>> generateAllNonAdjacentCombinations(int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            combinations.addAll(generateAllNonAdjacentCombinations(n, i));
        }
        return combinations;
    }

    private static List<List<Integer>> generateAllNonAdjacentCombinations(int n, int i) {
        return generateAllCombinations(n, i).stream()
                .filter(combination -> !isAdjacent(combination))
                .collect(Collectors.toList());
    }

    private static boolean isAdjacent(List<Integer> combination) {
        return IntStream.range(0, combination.size() - 1)
                .anyMatch(i -> Math.abs(combination.get(i) - combination.get(i + 1)) <= 1);
    }

    private static List<List<Integer>> generateAllCombinations(int n, int i) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateAllCombinations(n, i, 0, currentCombination, combinations);
        return combinations;
    }

    private static void generateAllCombinations(int n, int i, int start, List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (i == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int j = start; j < n; j++) {
            currentCombination.add(j);
            generateAllCombinations(n, i - 1, j + 1, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
