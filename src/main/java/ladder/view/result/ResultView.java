package ladder.view.result;

import ladder.domain.model.LadderLines;
import ladder.view.input.Users;

public interface ResultView {
    void print(Users users, LadderLines ladderLines);
}
