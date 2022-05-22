package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;

import java.util.stream.IntStream;

public class Output {
    public static void printLadder(Ladder ladder, Height height) {
        final String LADDER_YES = "-----|";
        final String LADDER_NO = "     |";

        IntStream.range(0, height.getHeight())
                .forEach(index -> System.out.println(
                        ladder.lines()
                                .stream()
                                .map(line -> line.point(index) ? LADDER_YES : LADDER_NO)
                                .reduce(LADDER_NO, (prevLadder, nextLadder) -> (prevLadder + nextLadder))));
    }

    public static void printPlayers(Players players) {
        printResult();
        players.players().forEach(player -> System.out.printf("%6s", player.getName()));
        System.out.println();
    }

    private static void printResult() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }
}
