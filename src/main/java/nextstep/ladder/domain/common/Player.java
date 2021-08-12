package nextstep.ladder.domain.common;

import java.util.Objects;

public class Player {

    private final Name name;
    private Result result;

    private Player(final Name name, final Result result) {
        this.name = name;
        this.result = result;
    }

    private Player(final Name name) {
        this.name = name;
    }

    public static Player of(final Name name) {
        return new Player(name);
    }

    public static Player of(final Name name, final Result result) {
        return new Player(name, result);
    }

    public void updateResult(final Result result) {
        this.result = result;
    }

    public Name getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
