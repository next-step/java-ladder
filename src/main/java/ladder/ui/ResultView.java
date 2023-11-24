package ladder.ui;

import ladder.domain.Coordinate;
import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.People;

public class ResultView {
    private ResultView() {
    }

    public static void printTitle(People people) {
        System.out.printf("실행결과%n%n");

        people.call().forEach(item -> System.out.printf(String.format("%5s ", item)));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.draw().forEach(ResultView::drawLine);
    }

    private static void drawLine(LadderLine ladderLine) {
        ladderLine.draw().forEach(item -> System.out.print(drawCoordinate(item)));
        System.out.println();
    }

    private static String drawCoordinate(Coordinate coordinate) {
        if (coordinate.find()) {
            return "---- |";
        }
        return "     |";
    }

}
