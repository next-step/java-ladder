package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        Players players = new Players(InputView.inputPerson());
        int height = InputView.inputLadderHeight();

        LadderFactory ladderFactory = new LadderFactory();
        Ladder ladder = ladderFactory.createRandomLadder(height, players.countPlayers());

        OutputView.outputResult(players, ladder);
    }
}
