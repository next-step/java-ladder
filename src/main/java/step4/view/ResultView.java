package step4.view;

import java.util.List;
import java.util.stream.Collectors;
import step4.domain.Cross;
import step4.domain.Ladder;
import step4.domain.LadderResult;
import step4.domain.column.LadderColumn;
import step4.domain.LadderLine;
import step4.domain.Point;

public class ResultView {

    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String LADDER_COLUMN = "%-3s   ";

    public static void printColumn(LadderColumn ladderColumn) {
        ladderColumn.names()
            .forEach(s -> System.out.printf(LADDER_COLUMN, s));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<LadderLine> ladderLines = ladder.ladderLines();
        ladderLines.stream()
            .map(ladderLine -> printByLadderLine(ladderLine))
            .forEach(System.out::println);
    }

    private static String printByLadderLine(LadderLine ladderLine) {
        List<Point> points = ladderLine.points();
        points = points.subList(0, points.size() - 1);
        return points.stream()
            .map(point -> printByPoint(point))
            .collect(Collectors
                .joining(LADDER_VERTICAL_LINE, LADDER_VERTICAL_LINE, LADDER_VERTICAL_LINE));
    }

    private static String printByPoint(Point point) {
        Cross cross = point.cross();
        if (cross.current()) {
            return LADDER_HORIZON;
        }
        return LADDER_EMPTY;
    }

    public static void printTarget(LadderResult ladderResult, String target) {

        LadderColumn startNames = ladderResult.startNames();
        LadderColumn resultNames = ladderResult.resultNames();
        List<Integer> ladderMoveResult = ladderResult.moveResult();

        System.out.println("실행 결과");
        if (target.equals("all")) {
            printAll(ladderMoveResult, startNames, resultNames);
            return;
        }

        System.out.println(target + " : " + resultNames.name(ladderMoveResult.get(startNames.index(target))));
    }

    private static void printAll(List<Integer> ladderMoveResult, LadderColumn startNames,
        LadderColumn resultNames) {
        for (int i = 0; i < ladderMoveResult.size(); i++) {
            System.out.println(startNames.name(i) + " : " + resultNames.name(ladderMoveResult.get(i)));
        }
    }
}
