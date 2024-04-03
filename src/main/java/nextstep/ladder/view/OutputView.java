package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLadder(int height, String[] names, LadderGame ladderGame) {
        printHeight(height);
        printNames(names);
        System.out.println(renderLine(ladderGame));
    }

    private static void printHeight(int height) {
        System.out.println(height);
    }

    private static void printNames(String[] names) {
        System.out.println("\n실행결과\n");
        for (String name : names) {
            System.out.printf("%5s", name.trim());
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    private static String renderLine(LadderGame ladderGame) {
        return ladderGame.getLines().stream()
                .map(line -> "     " + renderPoints(line.getPoints()) + "|\n")
                .collect(Collectors.joining());
    }

    private static String renderPoints(List<Boolean> points) {
        return points.stream()
                .map(point -> "|" + (point? "-----" : "     "))
                .collect(Collectors.joining());
    }

}
