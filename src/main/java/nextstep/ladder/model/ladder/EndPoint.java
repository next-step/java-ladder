package nextstep.ladder.model.ladder;

public class EndPoint {

    private final String score;

    private EndPoint(String score) {
        this.score = score;
    }

    public static EndPoint of(String score) {
        return new EndPoint(score);
    }

    public String score() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.score;
    }
}
