package ladder.view.result;

import ladder.domain.model.LadderLines;
import ladder.domain.model.Users;

public interface ResultView {
    void print(Users users, LadderLines ladderLines);
}
