package nextstep.ladder.view;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

public class ResultView {

    public static void printPlayers(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(System.out::print);

        System.out.println();
    }

    public static void printLines(Lines lines) {
        lines.getLines().forEach(System.out::println);
    }
}
