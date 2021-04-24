package ladder.domain;

import ladder.view.ResultView;

import java.util.Objects;
import java.util.stream.IntStream;

public class Reward {
    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
    }

    public String withWhiteSpaceReward() {
        if (reward.length() > ResultView.AISLE_WIDTH + 1) {
            return "";
        }
        int nullSpace = ResultView.AISLE_WIDTH + 1 - reward.length();
        StringBuilder sb = new StringBuilder();
        sb.append(reward);
        IntStream.rangeClosed(0, nullSpace)
                .forEach(i -> sb.append(" "));
        return sb.toString();
    }

    @Override
    public String toString() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
