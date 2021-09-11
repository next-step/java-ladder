package nextstep.ladder;

import nextstep.ladder.domain.AutoLadderGenerator;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {

        Players players = new Players(InputView.inputNames());
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(new AutoLadderGenerator().generate(ladderHeight, players.numberOfPlayers()));

        ResultView.printResult(players, ladder);
    }
}
