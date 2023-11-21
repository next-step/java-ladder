package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;

import java.util.List;

public final class ResultView {

    private ResultView() {
    }

    public static void printNames(List<String> userNames) {
        userNames.forEach(name -> System.out.print(name + "  "));
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("");
        ladder.lines().forEach(ResultView::printLine);

    }

    private static void printLine(Line line) {
        System.out.print("     |");
        line.points().forEach(ResultView::printPoint);
        System.out.println("");

    }

    private static void printPoint(boolean point) {
        String pointTruePrint = "-----";
        String pointFalsePrint = "     ";

        if (point == true) {
            System.out.print(pointTruePrint + "|");
            return;
        }

        System.out.print(pointFalsePrint + "|");
    }
}
