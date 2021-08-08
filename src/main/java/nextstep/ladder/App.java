package nextstep.ladder;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.ladder.LadderBound;
import nextstep.ladder.ladder.Prizes;
import nextstep.ladder.ladder.dto.LadderResult;
import nextstep.ladder.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class App {

    public static void main(String[] args) {
        Players players = Players.of(InputView.getInputPlayerName());
        Prizes prizes = Prizes.of(InputView.getInputLadderPrize());
        int height = InputView.getInputMaxLadderHeight();
        Ladder ladder = Ladder.of(LadderBound.of(players.count(), height));

        ResultView.printLadder(players, ladder, prizes);
        LadderResult result = ladder.play();
        ResultView.printPlayerResult(result, players, prizes);
    }
}
