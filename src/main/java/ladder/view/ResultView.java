package ladder.view;

import ladder.domain.ExecutionResults;
import ladder.domain.Ladder;
import ladder.domain.Persons;

import java.util.stream.Collectors;

public class ResultView {
    private static final String POINT_TRUE_CHARACTER = "-----";
    private static final String POINT_FALSE_CHARACTER = "     ";
    private static final String LINE_CHARACTER  = "|";
    private static final String SPACE_INPUT_CRITERIA = "%6s";

    private MessagePrinter messagePrinter;

    public ResultView() {
        this.messagePrinter = new MessagePrinter();
    }

    public void printPersons(Persons persons) {
        messagePrinter.println(System.lineSeparator() + "사다리 결과");
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator());
        persons.getPersons()
                .stream()
                .forEach(person ->
                        builder.append(String.format(SPACE_INPUT_CRITERIA, person.toString())));
        messagePrinter.println(builder.toString());
    }

    public void printLadder(Ladder ladder) {
        StringBuilder builder = new StringBuilder();
        ladder.getLines().stream()
                .forEach(line -> {
                    builder.append(String.format(SPACE_INPUT_CRITERIA, LINE_CHARACTER));
                    builder.append(line.getPoints().stream()
                            .map(point -> getPointCharacter(point.getPoint()))
                            .collect(Collectors.joining(LINE_CHARACTER)));
                    builder.append(System.lineSeparator());
                });
        messagePrinter.println(builder.toString());
    }

    private String getPointCharacter(Boolean point) {
        if (point) {
            return POINT_TRUE_CHARACTER;
        }
        return POINT_FALSE_CHARACTER;
    }

    public void printExecutionResults(ExecutionResults executionResults) {
        StringBuilder builder = new StringBuilder();
        executionResults.getExecutionResults()
                .stream()
                .forEach(executionResult ->
                        builder.append(String.format(SPACE_INPUT_CRITERIA, executionResult)));
        messagePrinter.println(builder.toString());
    }
}
