package nextstep.step2.view;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;

import java.util.List;

public class OutputView {

    public static void printLine(Line inputLine) {
        List<Boolean> line = inputLine.line();
        for (Boolean segment : line) {
            System.out.print(segment ? "|-----" : "|     ");
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

}
