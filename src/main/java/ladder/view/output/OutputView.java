package ladder.view.output;

import ladder.domain.Result;
import ladder.domain.reward.Rewards;
import ladder.domain.ladder.LadderLines;
import ladder.domain.person.People;

public interface OutputView {

    void ladderCreateResult(People people, LadderLines ladderLines, Rewards rewards);

    void gameResult(Result result);
}
