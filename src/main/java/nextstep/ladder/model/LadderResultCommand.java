package nextstep.ladder.model;

import java.util.Objects;

public final class LadderResultCommand {
    private static final String ALL = "all";

    private final String command;

    private LadderResultCommand(String command) {
        this.command = command;
    }

    public static LadderResultCommand from(String command) {
        validate(command);
        return new LadderResultCommand(command);
    }

    public boolean isAll() {
        return ALL.equalsIgnoreCase(command);
    }

    public UserName userName() {
        return new UserName(command);
    }

    private static void validate(String command) {
        if (Objects.isNull(command)) {
            throw new IllegalArgumentException("전달된 명령어는 null입니다.");
        }
        if (command.isEmpty()) {
            throw new IllegalArgumentException("전달된 명령어가 비어있습니다.");
        }
    }
}
