package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BridgesGeneratorByCreatingCandidates implements BridgesGenerator {

    private static List<List<Bridge>> candidates = new ArrayList<>();

    static void generateLadders(int numbersOfPeople) {
        List<List<Bridge>> result = new ArrayList<>(List.of(List.of(Bridge.of(false)), List.of(Bridge.of(true))));

        for (int i = 2; i < numbersOfPeople ; i++) {
            result = dp(result);
        }

        candidates = result;
    }

    static List<List<Bridge>> dp(List<List<Bridge>> result) {
        return result.stream()
                .flatMap(ladder -> {
                    List<Bridge> withFalse = new ArrayList<>(ladder);
                    withFalse.add(Bridge.of(false));
                    List<Bridge> withTrue = new ArrayList<>(ladder);
                    if (!ladder.get(ladder.size() - 1).canCrossBridge()) {
                        withTrue.add(Bridge.of(true));
                        return Stream.of(withFalse, withTrue);
                    }
                    return Stream.of(withFalse);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Bridge> generateBridges(Integer numbersOfPeople) {
        if (candidates.isEmpty()) {
            generateLadders(numbersOfPeople);
        }
        Collections.shuffle(candidates);
        return candidates.get(0);
    }



}
