package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;

import static nextstep.ladder.domain.Name.MAX_LENGTH_OF_NAME;

public final class ResultView {


    private ResultView() {
    }

    public static void printNames(List<String> userNames) {
        userNames.stream()
                .map(userName -> userName.concat(" ".repeat(MAX_LENGTH_OF_NAME - userName.length() + 1)))
                .forEach(System.out::print);
    }

    public static void printLadder(Ladder ladder, List<String> result) {
        System.out.println("사다리 결과");
        ladder.lines().forEach(ResultView::printLine);
        result.stream()
                .map(rs -> rs.concat(" ".repeat(MAX_LENGTH_OF_NAME - rs.length() + 1)))
                .forEach(System.out::print);
        System.out.println("");
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

    private static void printAllResult(LadderResult ladderResult, List<String> result) {
        ladderResult.value().forEach((playerName, res) -> System.out.println(playerName + " : " + result.get(res)));
    }

    public static void printResult(String playerName, LadderResult ladderResult, List<String> result) {
        System.out.println("실행 결과");
        if ("all".equals(playerName)) {
            printAllResult(ladderResult, result);
            return;
        }

        System.out.println(ladderResult.result(playerName, result));
    }
}
