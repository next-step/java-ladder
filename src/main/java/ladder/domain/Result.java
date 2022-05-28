package ladder.domain;

public class Result {

    private final Name playerName;
    private final Name value;

    public Result(Name playerName, Element result) {
        this.playerName = playerName;
        this.value = result.name();
    }

    public Name value() {
        return value;
    }

    public Name playerName() {
        return playerName;
    }
}
