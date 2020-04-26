package ladder.view;

import ladder.controller.response.LadderDto;
import ladder.domain.Line;
import ladder.view.constant.ConstPerson;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_FORMAT = "\n실행 결과\n";
    private static final String PERSON_NAME_FORMAT = "%5s";
    private static final String PERSON_NAME_DELIMITER = " ";
    private static final String LADDER_RESULT_VALUE_FORMAT = "%5s";
    private static final String LADDER_RESULT_VALUE_DELIMITER = " ";
    private static final String LADDER_SEPARATOR = "|";
    private static final String LADDER_LINE = "-";
    private static final String LADDER_EMPTY = " ";

    private static void printPersonNames(List<String> userNames) {
        System.out.println(userNames.stream()
                .map(name -> String.format(PERSON_NAME_FORMAT, name))
                .collect(Collectors.joining(PERSON_NAME_DELIMITER))
        );
    }

    public static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Boolean> linePoints = line.getPoint();
        int pointsCount = linePoints.size();

        addLine(false, stringBuilder);
        for (int index = 0; index < pointsCount; index++) {
            addLine(linePoints.get(index), stringBuilder);
        }

        System.out.println(stringBuilder.toString());
    }

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

    public static void printLadderResult(LadderDto ladderResult) {
        System.out.println(RESULT_FORMAT);

        printPersonNames(ladderResult.getPersonNames());
        ladderResult.getLines().forEach(ResultView::printLine);
        printLadderResultValues(ladderResult.getLadderResult());
    }

    private static void printLadderResultValues(List<String> resultValues) {
        System.out.println(resultValues.stream()
                .map(result -> String.format(LADDER_RESULT_VALUE_FORMAT, result))
                .collect(Collectors.joining(LADDER_RESULT_VALUE_DELIMITER))
        );
    }

}
