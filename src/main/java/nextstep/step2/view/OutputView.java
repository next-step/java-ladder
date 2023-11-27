package nextstep.step2.view;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printLine(Line inputLine) {
        List<Boolean> line = inputLine.points();
        for (Boolean points : line) {
            System.out.print(points ? "|-----" : "|     ");
        }
        System.out.print("|");
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.lines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    public static void printNames(String[] names) {

        Arrays.stream(names).forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

}
