package ladder;

import ladder.model.Player;
import ladder.view.InputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Player> players = InputView.askPlayers();

        int height = InputView.askHeight();

        System.out.println(players.size());
        System.out.println(height);

    }
}
