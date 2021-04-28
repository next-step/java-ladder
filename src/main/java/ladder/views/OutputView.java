package ladder.views;

import ladder.domain.*;

import java.util.List;

public class OutputView {
    private static final String POINT = "|";
    public static final String CONNECTION_LINE = "-----";
    public static final String EMPTY_SPACE = "     ";

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void print(Names names) {
        System.out.println();
        for (final Name name : names) {
            System.out.printf("%-" + (Name.MAX_NAME_LENGTH + 1) + "s", name.name());
        }
        System.out.println();
    }

    public static void print(Ladder ladder) {
        for (final LadderLine ladderLine : ladder.ladderLines()) {
            print(ladderLine);
        }
    }

    private static void print(LadderLine ladderLine) {
        final List<Point> points = ladderLine.points();

        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < points.size(); i++) {
            sb.append(view(points.get(i), i == points.size() - 1));
        }

        System.out.println(sb);
    }

    private static String view(Point point, boolean last) {
        if (last) {
            return POINT;
        }

        if (point.right()) {
            return POINT + CONNECTION_LINE;
        }

        return POINT + EMPTY_SPACE;
    }
}
