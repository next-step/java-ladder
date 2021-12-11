package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Player;

public class OutputView {
    public static void printPlayerList(List<Player> players) {
        players.stream()
                .map(Player::name)
                .map(Name::toString)
                .map(name -> String.format("%6s", name))
                .forEach(System.out::print);
        System.out.print("\n");
    }
}
