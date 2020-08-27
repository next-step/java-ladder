package ladder.domain.command;

import ladder.domain.LadderGame;
import ladder.domain.common.Printable;
import ladder.domain.element.Persons;

public interface LadderResultCommand {

    boolean match(Persons persons, String command);

    Printable showResult(LadderGame ladderGame, String command);
}
