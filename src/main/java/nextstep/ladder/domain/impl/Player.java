package nextstep.ladder.domain.impl;

import nextstep.ladder.exception.NullParameterException;
import nextstep.ladder.exception.OutOfRangeException;
import nextstep.ladder.utils.StringUtils;

import java.util.Objects;

public class Player {

    private static final int MAX_LENGTH = 5;

    private final String name;

    private Player(String name) {
        validPlayerNameLength(name);
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    private void validPlayerNameLength(String name) {
        if (StringUtils.isBlank(name)) {
            throw new NullParameterException(this);
        }
        if (name.length() > MAX_LENGTH) {
            throw OutOfRangeException.shouldLessThan(name.length(), MAX_LENGTH);
        }
    }

    @Override
    public String toString() {
        return String.format("%5s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
