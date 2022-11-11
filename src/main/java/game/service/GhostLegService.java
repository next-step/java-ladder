package game.service;

import game.constant.Case;
import game.domain.ladder.LadderResult;
import game.domain.ladder.Ladders;
import game.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GhostLegService {

    private final String ALL_PEOPLE = "all";

    public List<Boolean> generateRandomLines(int listSize) {
        return Stream.generate(RandomNumberGenerator::randomBoolean)
                .limit(listSize - 1)
                .collect(Collectors.toList());
    }

    public List<Boolean> filterLines(List<Boolean> lines, NumberStrategy numberStrategy) {
        boolean prevStatus = lines.get(0);

        for (int index = 1; index < lines.size(); index++) {
            boolean currentStatus = lines.get(index);

            Case nextStep = checkStatus(prevStatus, currentStatus);
            changeStatus(nextStep, index, lines, numberStrategy);
            prevStatus = lines.get(index);
        }

        return lines;
    }

    private Case checkStatus(boolean previous, boolean current) {
        if (previous && current) return Case.WITH_LADDER;
        if (!previous && !current) return Case.WITHOUT_LADDER;
        return Case.UNKNOWN;
    }

    private void changeStatus(Case nextStep, int index, List<Boolean> points, NumberStrategy numberStrategy) {
        if (nextStep == Case.WITH_LADDER) resolveWithLadderCase(index, points, numberStrategy.generateNumber());
        if (nextStep == Case.WITHOUT_LADDER) resolveWithoutLadderCase(index, points, numberStrategy.generateNumber());
    }

    private void resolveWithLadderCase(int index, List<Boolean> points, int generatedRandomNumber) {
        boolean validValue = validateWithLadderCase(index, points);
        switch (generatedRandomNumber) {
            case 0:
                points.set(index, false);
                break;
            case 1:
                points.set(index - 1, validValue);
                break;
        }
    }

    private void resolveWithoutLadderCase(int index, List<Boolean> points, int generatedRandomNumber) {
        boolean validValue = validateWithoutLadderCase(index, points);
        switch (generatedRandomNumber) {
            case 0:
                points.set(index, true);
                break;
            case 1:
                points.set(index - 1, validValue);
                break;
        }
    }

    private boolean validateWithoutLadderCase(int index, List<Boolean> points) {
        if (index >= 2) {
            return !points.get(index - 2);
        }
        return !points.get(index);
    }

    private boolean validateWithLadderCase(int index, List<Boolean> points) {
        if (index >= 2) {
            return points.get(index - 2);
        }
        return !points.get(index);
    }

    public List<LadderResult> findLadderResults(List<String> people, String person, List<String> results, Ladders ladders) {
        if (ALL_PEOPLE.equals(person)) {
            return ladders.findAllLadderResults(people, results);
        }
        return List.of(ladders.findOneLadderResult(person, people.indexOf(person), results));
    }
}
