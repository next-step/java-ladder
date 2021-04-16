package ladder.view;

import ladder.domain.ExecutionResultMap;
import ladder.domain.ExecutionResults;
import ladder.domain.Ladder;
import ladder.domain.Persons;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String POINT_TRUE_CHARACTER = "-----";
    private static final String POINT_FALSE_CHARACTER = "     ";
    private static final String LINE_CHARACTER  = "|";
    private static final String SPACE_INPUT_CRITERIA = "%6s";

    public void printPersons(Persons persons) {
        System.out.printf("%n사다리 결과%n");
        String personString = persons.getPersons()
                .stream()
                .map(person -> String.format(SPACE_INPUT_CRITERIA, person.toString()))
                .collect(joining());
        System.out.printf(String.format("%s", personString));
    }

    public void printLadder(Ladder ladder) {
        ladder.getLadderLines()
                .stream()
                .forEach(ladderLine -> {
                    String ladderLineStringString = String.format(SPACE_INPUT_CRITERIA, LINE_CHARACTER);
                    String ladderLineString = ladderLine.getPoints().stream()
                            .map(point -> getPointCharacter(point.isRight()))
                            .collect(joining(LINE_CHARACTER));
                    System.out.printf(String.format("%n%s%s", ladderLineStringString, ladderLineString));
                });
    }

    private String getPointCharacter(Boolean point) {
        if (point) {
            return POINT_TRUE_CHARACTER;
        }
        return POINT_FALSE_CHARACTER;
    }

    public void printExecutionResults(ExecutionResults executionResults) {
        String executionResultString = executionResults.getExecutionResults()
                .stream()
                .map(executionResult -> String.format(SPACE_INPUT_CRITERIA, executionResult))
                .collect(joining());
        System.out.printf(String.format("%n%s%n", executionResultString));
    }

    public void printExecutionResult(ExecutionResultMap executionResultMap, String personName) {
        System.out.printf("%n실행결과");
        System.out.printf(String.format("%n%s%n", executionResultMap.getExecutionResult(personName)));
    }

    public void printAllExecutionResult(ExecutionResultMap executionResultMap) {
        System.out.printf("%n실행결과");
        executionResultMap.getExecutionResultMap()
                .keySet()
                .forEach(personName ->
                        System.out.printf(String.format("%n%s : %s", personName,
                                executionResultMap.getExecutionResult(personName))));
    }
}
