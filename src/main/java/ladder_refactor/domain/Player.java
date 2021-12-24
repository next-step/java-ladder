package ladder_refactor.domain;

import ladder_refactor.exception.LadderInputException;

import java.util.Objects;

public class Player {

    private static final String ERR_NAME_SIZE = "이름은 최대 5글자 입니다.";
    private static final int NAME_SIZE = 5;
    public static final int PRINT_SIZE = 6;

    private final String name;

    public Player(String name) {
        this.name = valid(name);
    }

    private String valid(String name) {
        if (name.length() > NAME_SIZE) {
            throw new LadderInputException(ERR_NAME_SIZE);
        }
        return name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
