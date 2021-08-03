package nextstep.ladder;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.ladder.LadderHeight;
import nextstep.ladder.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class App {

    public static void main(String[] args) {
        String playerNames = InputView.getInputPlayerName();
        int height = InputView.getInputMaxLadderHeight();

        Players players = Players.of(playerNames);
        Ladder ladder = Ladder.of(LadderHeight.of(height), players.count() - 1);

        ResultView.print(players, ladder);
    }
}
