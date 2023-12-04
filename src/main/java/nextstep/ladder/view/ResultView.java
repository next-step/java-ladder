package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLadder(Ladder ladder) {

        System.out.println(ladder.getPlayerNames()
                .stream()
                .map(p -> String.format("%-6s", p))
                .collect(Collectors.joining("")));

        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.print("|");
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        for (Boolean route : line.routes()) {
            System.out.print("|");
            printRoute(route);
        }
    }

    private static void printRoute(Boolean route) {
        if(route) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
