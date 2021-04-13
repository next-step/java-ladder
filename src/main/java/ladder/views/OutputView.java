package ladder.views;

import ladder.domain.*;

public class OutputView {
    public static void print(Names names) {
        for (final Name name : names.names()) {
            System.out.printf("%-" + Name.MAX_NAME_LENGTH + 1 + "s\n", name.name());
        }
    }

    public static void print(Ladder ladder) {
        for (final LadderLine ladderLine : ladder.ladderLines()) {
            print(ladderLine);
        }
    }

    private static void print(LadderLine ladderLine) {
        final StringBuffer sb = new StringBuffer();
        sb.append("    ");
        for (final Point point : ladderLine.points()) {
            sb.append(view(point));
        }
        System.out.println(sb);
    }

    private static String view(Point point) {
        if (point == Point.BEGIN) {
            return "|-----";
        }

        return "|     ";
    }
}
