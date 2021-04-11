package ladder.view;

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

    public void printResult(Persons persons, Ladder ladder) {
        messagePrinter.println(System.lineSeparator() + "실행결과");
        printPersons(persons);
        printLadder(ladder);
    }

    private void printPersons(Persons persons) {
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator());
        persons.getPersons().stream()
                .forEach(person -> builder.append(String.format(SPACE_INPUT_CRITERIA, person.toString())));
        messagePrinter.println(builder.toString());
    }

    private void printLadder(Ladder ladder) {
        StringBuilder builder = new StringBuilder();
        ladder.getLines().stream()
                .forEach(line -> {
                    builder.append(String.format(SPACE_INPUT_CRITERIA, LINE_CHARACTER));
                    builder.append(line.getPoints().stream()
                            .map(point -> getPointCharacter(point))
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
}
