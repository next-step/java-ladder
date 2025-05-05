package nextstep.domain;

import static nextstep.domain.CommandEnum.*;

import java.util.Objects;

/**
 * 사다리게임 결과를 보고싶은 커맨드
 */
public class Command {
    private final String command;

    private Command(String command) {
        this.command = validate(command.trim());
    }

    public static Command of(String command) {
        return new Command(command);
    }

    public boolean isAll() {
        return ALL.equals(command);
    }

    public String validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 허용되지 않습니다.");
        }
        return input;
    }

    public String getValue() {
        return command;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Command command1 = (Command)o;
        return Objects.equals(command, command1.command);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(command);
    }
}
