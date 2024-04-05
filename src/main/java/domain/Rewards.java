package domain;

import view.ResultView;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public Position position(Reward reward) {
        if (!rewards.contains(reward)) {
            throw new IllegalArgumentException("없는 보상입니다.");
        }
        return new Position(rewards.indexOf(reward), 0);
    }

    public void display(LadderVisitor visitor) {
        visitor.visit(rewards);
    }

    public Reward findByPosition(int x) {
        return rewards.get(x);
    }
}
