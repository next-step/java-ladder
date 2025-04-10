package nextstep;

import nextstep.domain.ladder.Height;
import nextstep.domain.ladder.Ladder;
import nextstep.domain.player.Players;
import nextstep.generator.RandomPointGenerator;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Players players = InputView.getPlayersName();
        Height height = InputView.getMaxLadderHeight();

        RandomPointGenerator randomPointGenerator = new RandomPointGenerator();
        Ladder ladder = new Ladder(players.getPlayersCount(), height, randomPointGenerator);
        ResultView.printLadderView(players, ladder);
    }
}
