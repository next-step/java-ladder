package domain;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public Reward findByOrder(int order) {
        return rewards.get(order);
    }

    public void display(LadderVisitor visitor) {
        visitor.visit(rewards);
    }
}
