package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Names;

public class ResultView {

    private static final String VERTICAL = "|";
    private static final String CONNECTED = "-----";
    private static final String EMPTY = "     ";


    public static void printResult(Ladder ladderGame) {
        System.out.println("실행결과");

        printNames(ladderGame.getNames());
        printLadder(ladderGame.getLines());
    }

    private static void printNames(Names names) {
        names.getValues().forEach(name -> System.out.printf("%-6s", name.getValue()));
        System.out.println();
    }

    private static void printLadder(Lines ladder) {
        ladder.getValues().forEach(line -> printLine(line));
    }

    private static void printLine(Line line) {
        System.out.print(VERTICAL);
        line.getPoints().forEach(point -> {
            System.out.print(point ? CONNECTED : EMPTY);
            System.out.print(VERTICAL);
        });

        System.out.println();
    }
}
