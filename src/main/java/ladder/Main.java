package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGenerator;
import ladder.domain.player.Players;
import ladder.domain.player.PlayersGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Players players = PlayersGenerator.create(InputView.getPlayerNames());
        int width = players.getPlayerNumber();
        System.out.println();

        int height = InputView.getLadderHeight();
        System.out.println();

        Ladder ladder = new LadderGenerator().generate(height, width);
        ResultView.showResultMessage();
        ResultView.showPlayers(players);
        ResultView.showLadder(ladder);
    }
}
