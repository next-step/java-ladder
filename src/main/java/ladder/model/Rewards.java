package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Rewards {
    private static final String COMMA = ",";

    private List<Reward> rewards;

    private Rewards(String people) {
        this.rewards = new ArrayList<>();

        Arrays.asList(replaceSpace(people).split(COMMA)).stream()
                .forEach(reward -> this.rewards.add(Reward.of(reward)));
    }

    public static Rewards of(String rewards) {
        return new Rewards(rewards);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public int count() {
        return rewards.size();
    }

    private String replaceSpace(String people) {
        return people.replace(" ", "");
    }

    public Reward getRewardByIndex(int position) {
        return rewards.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "rewards=" + rewards +
                '}';
    }

}
