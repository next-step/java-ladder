package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    private static final String RESULT_LADDER = "사다리 결과";
    private static final String RESULT = "실행 결과";
    private static final String BLANK = "%-6s";
    private static final String BLANK_LINE = "    ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String VERTICAL_LINE = "     ";
    private static final String START_LINE = "|";
    private static final String ALL = "all";


    public void printLadder(Names names,
                            Lines lines,
                            List<String> result) {
        System.out.println(RESULT_LADDER);
        System.out.println();

        printName(names);
        printLines(lines);
        printResult(result);
        System.out.println();
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
        line.getAll().forEach(this::printPoint);
        System.out.println();
    }

    private void printPoint(Point point) {
        if (point.current()) {
            System.out.print(START_LINE + HORIZONTAL_LINE);
            return;
        }
        System.out.print(START_LINE + VERTICAL_LINE);
    }

    private void printResult(List<String> result) {
        result.forEach(s -> System.out.printf(BLANK, s));
        System.out.println();
    }

    public void result(LadderResult ladderResult,
                       String name) {
        System.out.println(RESULT);
        if (name.equals(ALL)) {
            ladderResult.results()
                    .forEach((player, result) -> System.out.println(player + " : " + result));
            return;
        }
        System.out.println(ladderResult.result(name));
        System.out.println();
    }

}
