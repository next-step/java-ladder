package ladder.view;

import ladder.domain.Line;
import ladder.view.constant.ConstPerson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_FORMAT = "실행 결과";
    private static final String PERSON_NAME_FORMAT = "%5s";
    private static final String PERSON_NAME_DELIMITER = " ";
    private static final String LADDER_SEPARATOR = "|";
    private static final String LADDER_LINE = "-";
    private static final String LADDER_EMPTY = " ";

    public static void printUserNames(String[] userNames) {
        System.out.println(Arrays.stream(userNames)
                .map(name -> String.format(PERSON_NAME_FORMAT, name))
                .collect(Collectors.joining(PERSON_NAME_DELIMITER))
        );
    }

    public static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Boolean> linePoints = line.getPoint();
        int pointsCount = linePoints.size();

        addLine(LADDER_EMPTY, stringBuilder);
        for (int index = 0; index < pointsCount; index++) {
            addLine(linePoints.get(index), stringBuilder);
        }
        stringBuilder.append("\n");

        System.out.println(stringBuilder.toString());
    }

    private static void addLine(boolean lineExist, StringBuilder stringBuilder) {
        if (lineExist) {
            addLine(LADDER_LINE, stringBuilder);
        }

        addLine(LADDER_EMPTY,stringBuilder);

        stringBuilder.append(LADDER_SEPARATOR);
    }

    private static void addLine(String lineType, StringBuilder stringBuilder) {
        for (int i = 0; i < ConstPerson.PERSON_NAME_SIZE_MAX; i++) {
            stringBuilder.append(lineType);
        }

    }
}
