package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Names;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    private static final String WALL = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "     ";

    public static void printParticipants(Names names) {
        System.out.println();
        System.out.println("실행 결과");
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
        line.points().forEach(point -> System.out.print(WALL + judgeLineOrBlank(point)));
        System.out.println(WALL);
    }

    private static String judgeLineOrBlank(Boolean point) {
        if (point) {
            return LINE;
        }
        return BLANK;
    }
}
