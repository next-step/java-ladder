package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderResultView;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:40
 */
public class LadderGame {
    public static void main(String[] args) {
        List<String> names = LadderInputView.inputNames();
        List<String> executeResult = LadderInputView.inputExecuteResult(names.size());
        Ladder ladder = new Ladder(names.size(), LadderInputView.inputLadderHeight());
        LadderResultView.showList(names);
        LadderResultView.showLadder(ladder.showLadder());
        LadderResultView.showList(executeResult);

        LadderResult ladderResult = new LadderResult(ladder, names, executeResult);

        while (true) {
            String input = LadderInputView.inputSeeResult(names);
            LadderResultView.showLadderResult(ladderResult.findResultByName(input));

            if (input.equals("all")) {
                break;
            }
        }

    }
}
