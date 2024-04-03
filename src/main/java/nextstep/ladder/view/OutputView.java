package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printHeight(int height) {
        System.out.println(height);
    }

    public static void printNames(String[] names) {
        System.out.println("\n실행결과\n");
        for (String name : names) {
            System.out.printf("%5s", name.trim());
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    public static void printLadder(LadderGame ladderGame) {
        System.out.println(renderLine(ladderGame));
    }

    private static String renderLine(LadderGame ladderGame) {
        //StringBuilder sb = new StringBuilder();
        //for (Line line : ladderGame.getLines()) {
        //    sb.append("     ");
        //    sb.append(renderPoints(line.getPoints()));
        //    sb.append("|\n");
        //}
        //return sb.toString();
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
