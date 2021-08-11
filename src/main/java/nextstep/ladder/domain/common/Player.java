package nextstep.ladder.domain.common;

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

    public void updateResult(final Result result) {
        this.result = result;
    }

    public Name getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }
}
