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
import java.util.stream.Collectors;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(toPlayers());
        Height height = new Height(InputView.printInputLadderHeight());

        Ladder ladder = Ladder.createLadder(players, height);

        ResultView.printPlayerName(players.getPlayers());
        ResultView.printLadder(ladder.getLines());
    }

    private static List<Player> toPlayers() {
        return InputView.printInputNames().stream()
                .map(name -> new Player(new PlayerName(name.trim())))
                .collect(Collectors.toList());
    }

}
