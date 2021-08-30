package step2.view;

import step2.domain.Line;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String NAME_SPACE = "   ";
    private static final String GUIDE_HEAD_LINE = "실행 결과";

    public static void printHeader() {
        System.out.println(GUIDE_HEAD_LINE);
    }

    public static void printParticipant(List<String> participantNameList) {
        participantNameList.stream()
                .map(s -> s + NAME_SPACE)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadderResult(List<Line> lines) {
        lines.stream()
                .map(ResultView::printByLine)
                .forEach(System.out::println);
    }

    public static String printByLine(Line line) {
        return line.getPoints()
                .stream()
                .map(ResultView::printByPoint)
                .collect(Collectors.joining(LADDER_VERTICAL_LINE, LADDER_VERTICAL_LINE, LADDER_VERTICAL_LINE));
    }

    public static String printByPoint(Boolean point) {
        if (point) {
            return LADDER_HORIZON;
        }
        return LADDER_EMPTY;
    }
}
