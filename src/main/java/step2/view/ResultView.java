package step2.view;

import step2.domain.LadderGameColumn;
import step2.domain.Line;
import step2.domain.Result;

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

    public static void printParticipant(List<String> participantNames) {
        participantNames.stream()
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

    public static void printResultColumn(Result result) {
        result.getItems()
                .stream()
                .map(s -> s + NAME_SPACE)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printResultOfTarget(String target, List<LadderGameColumn> ladderGameColumns, Result result) {
        if (target.equals("all")) {
            printAllResult(ladderGameColumns, result);
            return;
        }
        System.out.println("target");
        ladderGameColumns.stream()
                .filter(ladderGameColumn -> ladderGameColumn.getName().equals(target))
                .forEach(ladderGameColumn -> System.out.println(ladderGameColumn.getName() + " : " + result.getItems().get(ladderGameColumn.getPosition())));
        return;

    }

    private static void printAllResult(List<LadderGameColumn> ladderGameColumns, Result result) {
        System.out.println("all");
        ladderGameColumns.stream()
                .map(ladderGameColumn -> ladderGameColumn.getName() + " : " + result.getItems().get(ladderGameColumn.getPosition()))
                .forEach(System.out::println);
    }
}