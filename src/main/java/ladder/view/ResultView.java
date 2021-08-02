package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.List;

public interface ResultView {
    void printResult(Players players, Ladder ladder);

    void printException(Exception e);
}
