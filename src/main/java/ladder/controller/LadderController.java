package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Player;
import ladder.domain.user.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(toPlayers());
        Height height = new Height(InputView.printInputLadderHeight());

        Ladder ladder = Ladder.createLadder(players, height);

        ResultView.printResult(players.getPlayers(), ladder.getLines());
        ResultView.printLadder(ladder.getLines());
    }

    private static List<Player> toPlayers() {
        List<String> players = InputView.printInputNames();
        return players.stream()
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
    }

}
