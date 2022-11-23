package game.service;

import game.domain.ladder.LadderResult;
import game.domain.ladder.Ladders;
import game.domain.ladder.Line;
import game.domain.ladder.ValueStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GhostLegService {

    private static final String ALL_PEOPLE = "all";

    public List<Line> generateRandomLines(int heightOfLegs, int numOfPeople, ValueStrategy valueStrategy) {
        return Stream.generate(() -> Line.of(numOfPeople, valueStrategy)).limit(heightOfLegs).collect(Collectors.toList());
    }

    public List<LadderResult> findLadderResults(List<String> people, String person, List<String> results, Ladders ladders) {
        if (ALL_PEOPLE.equals(person)) {
            return ladders.findAllLadderResults(people, results);
        }
        return List.of(ladders.findOneLadderResult(person, people.indexOf(person), results));
    }
}
