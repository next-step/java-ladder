package ladder.domain;

public class Result {

    private final Name playerName;
    private final Name result;

    public Result(Name playerName, Element result) {
        this.playerName = playerName;
        this.result = result.name();
    }
}
