package ladder.view.result;

import ladder.common.Csv;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.user.LadderResult;
import ladder.domain.user.LadderUsers;

public interface ResultView {
    void print(LadderUsers ladderUsers, LadderLines ladderLines, Csv ladderResults);
    void print(LadderResult ladderResult);
}
