package nextstep.ladder.domain.ladder;

public class Reward {

    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "reward='" + reward + '\'' +
                '}';
    }
}
