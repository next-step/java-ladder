package ladder.domain.command;

import ladder.domain.LadderGame;
import ladder.domain.element.LadderPrizes;
import ladder.domain.element.Persons;

public class AllResultCommand implements LadderResultCommand {

    private static final String ALL_COMMAND = "all";

    @Override
    public boolean match(Persons persons, String command) {
        return command.equals(ALL_COMMAND);
    }

    @Override
    public LadderPrizes showResult(LadderGame ladderGame, String command) {
        return ladderGame.getAllResult();
    }
}
