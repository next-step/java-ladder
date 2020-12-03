package ladder;

import static ladder.ui.OutputView.RESULT_ALL_KEYWORD;

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

        OutputView.printPreparedGame(ladderGameInfo, ladder);
        String name;
        do {
            name = InputView.inputNameWantShowResult();
            OutputView.printLadderGameResult(name, ladderGameInfo, ladder);
        } while (!RESULT_ALL_KEYWORD.equals(name));
    }
}
