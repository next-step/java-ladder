package ladder.domain.command;

import ladder.domain.LadderGame;
import ladder.domain.element.LadderPrizes;

public class AllResultCommand implements LadderResultCommand {

    private static final String ALL_COMMAND = "all";

    @Override
    public boolean match(String command) {
        return command.equals(ALL_COMMAND);
    }

    @Override
    public LadderPrizes showResult(LadderGame ladderGame, String command) {
        return ladderGame.getAllResult();
    }
}
