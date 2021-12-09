package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Player;
import ladder.domain.user.PlayerName;
import ladder.domain.user.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(toPlayers());
        Height height = new Height(InputView.printInputLadderHeight());

        Ladder ladder = Ladder.createLadder(players, height);

        ResultView.printPlayerName(players);
        ResultView.printLadder(ladder);
    }

    private static List<Player> toPlayers() {
        List<Player> users = new ArrayList<>();
        for (String name : InputView.printInputNames()) {
            users.add(new Player(new PlayerName(name.trim())));
        }
        return users;
    }

}
