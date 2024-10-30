package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;

public class OutputView {

    private static final String EMPTY = "     ";
    private static final String LINE = "-----";
    private static final String HORIZONTAL_LINE = "|";

    public static void rendering(Names names, Ladder ladder) {
        System.out.println("실행결과");
        renderName(names);
        renderLadder(ladder);
    }

    private static void renderName(Names names) {
        for (String name : names) {
            System.out.printf(" ".repeat(6 - name.length()) + name);
        }
        System.out.println();
    }

    private static void renderLadder(Ladder ladder) {
        for (Lines lines : ladder) {
            System.out.print(EMPTY);
            System.out.print(HORIZONTAL_LINE);
            renderLine(lines);
            System.out.println();
        }
    }

    private static void renderLine(Lines lines) {
        for (Boolean line : lines) {
            System.out.print(line(line));
            System.out.print(HORIZONTAL_LINE);
        }
    }

    private static String line(Boolean line) {
        if (line) {
            return LINE;
        }
        return EMPTY;
    }
}
