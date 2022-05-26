package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

import java.util.List;
import java.util.stream.IntStream;

public class Output {
    public static void printLadder(Ladder ladder, Height height) {
        final String LADDER_YES = "-----|";
        final String LADDER_NO = "     |";

        IntStream.range(0, height.getHeight())
                .forEach(index -> System.out.println(
                        ladder.lines()
                                .stream()
                                .map(line -> line.bar(index) ? LADDER_YES : LADDER_NO)
                                .reduce(LADDER_NO, (prevLadder, nextLadder) -> (prevLadder + nextLadder))));
    }

    public static void printPlayers(Players players) {
        printLadder();
        players.players().forEach(player -> System.out.printf("%6s", player.getName()));
        System.out.println();
    }

    private static void printLadder() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    public static void printResults(List<String> results) {
        results.forEach(result -> System.out.printf("%6s", result));
        System.out.println();
        System.out.println();
    }

    public static void printResultsOfPlayers(List<Player> selectedPlayers) {
        System.out.println("실행 결과");
        selectedPlayers.forEach(player -> System.out.printf(String.format("%s : %s \n", player.getName(), player.getResult())));
    }
}
