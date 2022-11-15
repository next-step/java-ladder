package laddergame.domain;

import java.util.Objects;

public class Player {
    private final Name name;
    private Result result;

    private Player(Name name, Result result) {
        this.name = name;
        this.result = result;
    }

    public Player(String name) {
        this(new Name(name), (Result) null);
    }

    public Player(String name, String result) {
        this(new Name(name), new Result(result));
    }

    public void saveResult(Result result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(result, player.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, result);
    }

    public Name getName() {
        return this.name;
    }

    public Result getResult() {
        return result;
    }
}
