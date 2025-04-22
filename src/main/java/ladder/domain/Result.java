package ladder.domain;

public class Result {
    private final String name;
    private final String reward;

    public Result(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return name + " : " + reward;
    }
}
