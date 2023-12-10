package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;

import static nextstep.ladder.domain.Name.MAX_LENGTH_OF_NAME;

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
        ladder.result().stream()
                .map(rs -> rs.concat(" ".repeat(MAX_LENGTH_OF_NAME - rs.length() + 1)))
                .forEach(System.out::print);

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

    public static void printResult(List<String> result) {
        System.out.println("실행 결과");
        System.out.println(result.get(0));
    }
}
