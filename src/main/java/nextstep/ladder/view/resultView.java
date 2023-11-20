package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;

import java.util.List;

public class resultView {

    private static final String START = "실행결과";
    private static final String LADDER_LINE = "|";
    private static final String LADDER_POINT = "-----";
    private static final String LADDER_BLANK = "     ";
    private static final String LADDER_START = "   ";
    private static final String NAME_BLANK = "  ";

    public static void printLadder(Names names, Ladder ladder) {
        System.out.println(START);
        printNames(names.nameList());
        printLadderLine(ladder.height());
    }

    private static void printNames(List<Name> names) {
        names.stream().forEach(name -> System.out.print(name.user() + NAME_BLANK));
        System.out.println();
    }

    private static void printLadderLine(List<Line> ladder) {
        ladder.stream().forEach(line -> System.out.println(LADDER_START + linePrint(line) + LADDER_LINE));
    }

    private static String linePrint(Line line) {
        StringBuilder builder = new StringBuilder();
        line.points().stream().forEach(point -> {
            builder.append(LADDER_LINE);
            builder.append(printLadderPoint(point));
        });
        return builder.toString();
    }

    private static String printLadderPoint(boolean point) {
        if (point) {
            return LADDER_POINT;
        }
        return LADDER_BLANK;
    }
}
