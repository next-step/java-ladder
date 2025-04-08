package nextstep;

import nextstep.domain.ladder.Height;
import nextstep.domain.ladder.Ladder;
import nextstep.domain.player.Players;
import nextstep.generator.RandomNumberGenerator;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Players players = InputView.getPlayersName();
        Height height = InputView.getMaxLadderHeight();

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Ladder ladder = new Ladder(players, height, randomNumberGenerator);
        ResultView.printLadderView(players, ladder);
    }
}
