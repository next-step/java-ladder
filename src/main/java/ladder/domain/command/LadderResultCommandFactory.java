package ladder.domain.command;

import java.util.ArrayList;
import java.util.List;

public class LadderResultCommandFactory {

    private static final List<LadderResultCommand> commands = new ArrayList<>();

    static {
        commands.add(new AllResultCommand());
        commands.add(new PersonResultCommand());
    }

    public static LadderResultCommand ladderResultCommand(String command) {
        return commands.stream()
                .filter(ladderCommand -> ladderCommand.match(command))
                .findFirst()
                .get();
    }
}
