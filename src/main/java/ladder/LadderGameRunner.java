package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.model.LadderGameInfo;
import ladder.ui.InputView;
import ladder.ui.OutputView;

public class LadderGameRunner {

    public static void main(String[] args) {
        LadderGameInfo ladderGameInfo = InputView.ladderGameInfo();

        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.generateLadder(ladderGameInfo);

        OutputView.printConstructedGame(ladderGameInfo.getUsers(), ladder);
    }
}
