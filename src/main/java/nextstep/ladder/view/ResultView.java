package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderPlayers;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Results;

import java.util.List;

import static nextstep.ladder.domain.Name.MAX_LENGTH_OF_NAME;

public final class ResultView {


    private ResultView() {
    }

    public static void printLadder(Ladder ladder, LadderPlayers ladderPlayers, Results results) {
        System.out.println("사다리 결과");
        printNames(ladderPlayers);
        ladder.lines().forEach(ResultView::printLine);
        results.values().stream()
                .map(rs -> rs.value().concat(" ".repeat(Math.max(MAX_LENGTH_OF_NAME - rs.value().length() + 1, 0))))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printNames(LadderPlayers ladderPlayers) {
        ladderPlayers.values().stream()
                .map(name -> name.value().concat(" ".repeat(Math.max(MAX_LENGTH_OF_NAME - name.value().length() + 1, 0))))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLine(Line line) {
        System.out.print("|");
        line.points().forEach(ResultView::printPoint);
        System.out.println();

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

    private static void printAllResult(LadderResult ladderResult) {
        ladderResult.value().forEach((playerName, res) -> System.out.println(playerName.value() + " : " + res.value()));
    }

    public static void printResult(Name playerName, LadderResult ladderResult) {
        System.out.println("실행 결과");
        if (new Name("all").equals(playerName)) {
            printAllResult(ladderResult);
            return;
        }

        System.out.println(ladderResult.result(playerName));
    }
}
