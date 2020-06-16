package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

public class ResultView {

    public static void printResult(Ladder ladder) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        printPlayers(ladder.getPlayers());

        printLines(ladder.getLines());
    }

    private static void printPlayers(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(name -> System.out.print(name + " "));

        System.out.println();
    }

    private static void printLines(Lines lines) {
        lines.getLines().forEach(System.out::println);
    }
}
