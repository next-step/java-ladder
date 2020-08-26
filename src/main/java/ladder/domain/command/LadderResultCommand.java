package ladder.domain.command;

import ladder.domain.LadderGame;
import ladder.domain.common.Printable;

public interface LadderResultCommand {

    boolean match(String command);

    Printable showResult(LadderGame ladderGame, String command);
}
