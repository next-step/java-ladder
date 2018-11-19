package game.ladder.domain;

public class GameResult {

    private final Name name;
    private final Expect expect;

    public GameResult(Name name, Expect expect) {
        this.name = name;
        this.expect = expect;
    }

    public String getStringResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.getValue()).append(" : ").append(expect.getValue());
        return sb.toString();
    }

}
