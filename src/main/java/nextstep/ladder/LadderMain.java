package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderRequireElement;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderResultView;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:40
 */
public class LadderMain {
    public static void main(String[] args) {
        LadderRequireElement ladderRequireElement = new LadderRequireElement(LadderInputView.inputNames(),
                LadderInputView.inputExecuteResult());

        Ladder ladder = new Ladder(ladderRequireElement.numberOfParticipant(), LadderInputView.inputLadderHeight());

        LadderGame ladderGame = new LadderGame(ladderRequireElement, ladder);
        LadderResultView.showLadder(ladderGame);

        LadderResult ladderResult = ladderGame.getLadderResult();

        while (true) {
            String input = LadderInputView.inputSeeResult(ladderRequireElement.getParticipant());
            LadderResultView.showLadderResult(ladderResult.findResultByName(input));

            if ("all".equals(input)) {
                break;
            }
        }

    }
}
