package ladder.domain.command;

import ladder.domain.element.Persons;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.common.LadderMessage.UNEXPECTED_ERROR_MESSAGE;

public class LadderResultCommandFactory {

    private static final List<LadderResultCommand> commands = new ArrayList<>();

    static {
        commands.add(new AllResultCommand());
        commands.add(new PersonResultCommand());
    }

    public static LadderResultCommand ladderResultCommand(Persons persons, String command) {
        return commands.stream()
                .filter(ladderCommand -> ladderCommand.match(persons, command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(UNEXPECTED_ERROR_MESSAGE));
    }
}
