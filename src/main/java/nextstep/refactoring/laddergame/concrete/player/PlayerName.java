package nextstep.refactoring.laddergame.concrete.player;

import java.util.Objects;

public class PlayerName {

    private static final int MAXIMUM_LENGTH = 5;
    private static final int MINIMUM_LENGTH = 1;

    private final String name;

    public PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 최소 한 글자, 최대 다섯 글자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerName)) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
