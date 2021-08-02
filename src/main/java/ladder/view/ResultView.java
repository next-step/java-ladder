package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public interface ResultView {
    void printResult(Players players, Ladder ladder);

    void printException(Exception e);
}
