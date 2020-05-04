package ladder.view;

import ladder.domain.*;
import ladder.view.constant.ConstPerson;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultView {
    private static final String RESULT_FORMAT = "\n사다리 결과\n";
    private static final String PERSON_NAME_FORMAT = "%5s";
    private static final String PERSON_NAME_DELIMITER = " ";
    private static final String LADDER_RESULT_VALUE_FORMAT = "%5s";
    private static final String LADDER_RESULT_VALUE_DELIMITER = " ";
    private static final String LADDER_SEPARATOR = "|";
    private static final String LADDER_LINE = "-";
    private static final String LADDER_EMPTY = " ";

    private static void addLine(boolean lineExist, StringBuilder stringBuilder) {
        if (lineExist) {
            addLine(LADDER_LINE, stringBuilder);
            stringBuilder.append(LADDER_SEPARATOR);
            return;
        }

        addLine(LADDER_EMPTY,stringBuilder);
        stringBuilder.append(LADDER_SEPARATOR);
    }

    private static void addLine(String lineType, StringBuilder stringBuilder) {
        for (int i = 0; i < ConstPerson.PERSON_NAME_SIZE_MAX; i++) {
            stringBuilder.append(lineType);
        }

    }

    public static void printPersons(Persons persons) {
        System.out.println(RESULT_FORMAT);
        List<String> personNames = persons.getPersons().stream()
                .map(Person::nameOf)
                .collect(Collectors.toList());

        System.out.println(personNames.stream()
                .map(name -> String.format(PERSON_NAME_FORMAT, name))
                .collect(Collectors.joining(PERSON_NAME_DELIMITER))
        );
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    public static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Point> linePoints = line.getPoints();
        int pointsCount = linePoints.size();

        for (int index = 0; index < pointsCount; index++) {
            addLine(linePoints.get(index).getDirection().isLeft(), stringBuilder);
        }

        System.out.println(stringBuilder.toString());
    }

    public static void printRewards(Rewards rewards) {
        System.out.println(rewards.getValues().stream()
                .map(result -> String.format(LADDER_RESULT_VALUE_FORMAT, result))
                .collect(Collectors.joining(LADDER_RESULT_VALUE_DELIMITER))
        );
    }
}
