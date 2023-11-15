package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;

public class ResultView {

    private static final String RESULT = "실행결과";
    private static final String BLANK = "%-6s";
    private static final String BLANK_LINE = "    ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String VERTICAL_LINE = "     ";
    private static final String LINE_START = "|";

    public void result(Ladder ladder) {
        System.out.println(RESULT);
        System.out.println();

        printName(ladder.getNames());
        printLines(ladder.getLines());
    }

    private void printName(Names names) {
        names.getAll().forEach(name -> System.out.printf(BLANK, name.toString()));
        System.out.println();
    }

    private void printLines(Lines lines) {
        lines.getAll().forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print(BLANK_LINE);
        System.out.print(LINE_START);
        line.getAll().forEach(this::printPoint);
        System.out.println();
    }

    private void printPoint(Boolean point) {
        if (point) {
            System.out.print(HORIZONTAL_LINE + LINE_START);
            return;
        }
        System.out.print(VERTICAL_LINE + LINE_START);
    }
}
