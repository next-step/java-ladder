package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderPlayers;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputNames();

        Results inputResult = InputView.inputResult();
        int maxHeightOfLadder = InputView.inputMaxHeightOfLadder();

        Ladder ladder = new Ladder(ladderPlayers, Lines.of(ladderPlayers.size(), maxHeightOfLadder));

        ResultView.printLadder(ladder, ladderPlayers, inputResult);

        LadderResult ladderResult = ladder.play(inputResult);

        Name playerName = null;
        while (!new Name("all").equals(playerName)) {
            playerName = InputView.inputResultPlayerName();
            ResultView.printResult(playerName, ladderResult);
        }
    }
}
