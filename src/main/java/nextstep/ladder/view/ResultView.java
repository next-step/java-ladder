package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Point;

import java.util.List;

import static nextstep.ladder.Name.MAX_LENGTH_OF_NAME;

public final class ResultView {


    private ResultView() {
    }

    public static void printResultString() {
        System.out.println("실행결과\n");
    }

    public static void printNames(List<String> userNames) {
        userNames.stream()
                .map(userName -> userName.concat(" ".repeat(MAX_LENGTH_OF_NAME - userName.length() + 1)))
                .forEach(System.out::print);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("");
        ladder.lines().forEach(ResultView::printLine);

    }

    private static void printLine(Line line) {
        System.out.print("|");
        line.points().forEach(ResultView::printPoint);
        System.out.println("");

    }

    private static void printPoint(Point point) {
        String pointTruePrint = "-----";
        String pointFalsePrint = "     ";

        if (point.isActive()) {
            System.out.print(pointTruePrint + "|");
            return;
        }

        System.out.print(pointFalsePrint + "|");
    }
}
