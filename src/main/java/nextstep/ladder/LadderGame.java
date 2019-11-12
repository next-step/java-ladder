package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
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
        Ladder ladder = new Ladder(names.size(), LadderInputView.inputLadderHeight());
        LadderResultView.showUsers(names);
        LadderResultView.showLadder(ladder.showLadder());
    }
}
