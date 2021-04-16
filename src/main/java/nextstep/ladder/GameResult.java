package nextstep.ladder;

public class GameResult {
    private final String name;
    private final String reward;

    public GameResult(final String name, final String reward) {
        this.name = name;
        this.reward = reward;
    }

    public String name() {
        return name;
    }

    public String reward() {
        return reward;
    }
}
