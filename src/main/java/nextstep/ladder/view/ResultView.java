package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;

public class ResultView {

    private static final int NAME_WIDTH = 6;

    public static void printPlayers(Players players) {
        players.getPlayers().forEach(person ->
            System.out.printf("%-" + NAME_WIDTH + "s", person.name())
        );
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines().forEach(line -> {
            System.out.print("    ");
            line.points().forEach(point -> {
                System.out.print(point.hasRight() ? "|-----" : "|     ");
            });
            System.out.println("|");
        });
    }

    public static void printResults(Results results) {
        results.getResults().forEach(result -> {
            System.out.printf("%-" + NAME_WIDTH + "s", result.getResult());
        });
        System.out.println();
    }
}
