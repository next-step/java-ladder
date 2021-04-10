package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Persons;

import java.util.stream.Collectors;

public class ResultView {
    private static final String POINT_TRUE_CHARACTER = "-----";
    private static final String POINT_FALSE_CHARACTER = "     ";
    private static final String LINE_CHARACTER  = "|";
    private static final String SPACE_INPUT_CRITERIA = "%6s";

    public void printResult(Persons persons, Ladder ladder) {
        MessagePrinter.printlnMessageAfterNewLine("실행결과");
        printPersons(persons);
        printLadder(ladder);
    }

    private void printPersons(Persons persons) {
        MessagePrinter.printNewLine();
        persons.getPersons().stream()
                .forEach(person -> MessagePrinter.printMessage(String.format(SPACE_INPUT_CRITERIA, person.toString())));
        MessagePrinter.printNewLine();
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().stream()
                .forEach(line -> printLine(line));
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(SPACE_INPUT_CRITERIA, LINE_CHARACTER));
        builder.append(line.getPoints().stream()
                .map(point -> getPointCharacter(point))
                .collect(Collectors.joining(LINE_CHARACTER)));
        MessagePrinter.printlnMessage(builder.toString());
    }

    private String getPointCharacter(Boolean point) {
        if (point) {
            return POINT_TRUE_CHARACTER;
        }
        return POINT_FALSE_CHARACTER;
    }
}
