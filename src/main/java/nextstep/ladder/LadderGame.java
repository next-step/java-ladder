package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderRequireElement;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderResultView;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:40
 */
public class LadderGame {
    public static void main(String[] args) {
        LadderRequireElement ladderRequireElement = new LadderRequireElement(LadderInputView.inputNames(),
                LadderInputView.inputExecuteResult());

        Ladder ladder = new Ladder(ladderRequireElement.numberOfParticipant(), LadderInputView.inputLadderHeight());
        LadderResultView.showList(ladderRequireElement.getParticipant());
        LadderResultView.showLadder(ladder.showLadder());
        LadderResultView.showList(ladderRequireElement.getExecutionResult());

        LadderResult ladderResult = new LadderResult(ladder, ladderRequireElement.getParticipant(), ladderRequireElement.getExecutionResult());

        while (true) {
            String input = LadderInputView.inputSeeResult(ladderRequireElement.getParticipant());
            LadderResultView.showLadderResult(ladderResult.findResultByName(input));

            if ("all".equals(input)) {
                break;
            }
        }

    }
}
