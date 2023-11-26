package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;

import static nextstep.ladder.domain.Direction.RIGHT;

public class OutputView {

    private OutputView() {
    }

    private static final String WALL = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "     ";

    public static void printParticipants(Names names) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        names.names().forEach(System.out::print);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println();
        List<Line> lines = ladder.lines();
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(BLANK);
        line.directions().forEach(point -> System.out.print(WALL + judgeLineOrBlank(point)));
        System.out.println();
    }

    private static String judgeLineOrBlank(Direction direction) {
        if (direction == RIGHT) {
            return LINE;
        }
        return BLANK;
    }

    public static void printPrizes(Prizes prizes) {
        prizes.prizes().forEach(System.out::print);
    }
}
