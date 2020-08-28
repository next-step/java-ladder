package ladder.domain.command;

import ladder.domain.LadderGame;
import ladder.domain.element.Persons;
import ladder.domain.element.Prize;

public class PersonResultCommand implements LadderResultCommand {
    @Override
    public boolean match(Persons persons, String command) {
        return persons.exists(command);
    }

    @Override
    public Prize showResult(LadderGame ladderGame, String command) {
        return ladderGame.getResult(command);
    }
}
