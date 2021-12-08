package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Player;
import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    public static void main(String[] args) {

        Players players = new Players(toPlayers(InputView.printInputNames()));
        Height height = new Height(InputView.printInputLadderHeight());
        ResultView.printLadder(players, height);
    }

    private static List<Player> toPlayers(List<String> printInputNames) {
        List<Player> users = new ArrayList<>();
        for (String name : InputView.printInputNames()) {
            users.add(new Player(new PlayerName(name.trim())));
        }
        return users;
    }

}
