package ladder.domain.command;

import ladder.domain.LadderGame;
import ladder.domain.element.Prize;

public class PersonResultCommand implements LadderResultCommand {
    @Override
    public boolean match(String command) {
        return true;
    }

    @Override
    public Prize showResult(LadderGame ladderGame, String command) {
        return ladderGame.getResult(command);
    }
}
