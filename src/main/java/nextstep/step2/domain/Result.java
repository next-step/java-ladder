package nextstep.step2.domain;

public class Result {
    private final Integer position;
    private final String reward;

    public Result(int position, String reward) {
        this.position = position;
        this.reward = reward;
    }

    public boolean equalsPosition(final int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return reward;
    }
}
