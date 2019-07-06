package ladder.model;

import java.util.Map;

public class Player {

    private final String name;
    private Position position;

    public Player(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    Position ride(Direction direction) {
        this.position = direction.move(this.position);
        return this.position;
    }

    public Position ride(Layer layer) {
        int position = this.position.getValue();
        Direction direction = layer.getDirection(position);
        return ride(direction);
    }

    public Result takeReward(Rewards rewards, Result result) {
        int index = this.position.getValue();
        Reward reward = rewards.getReward(index);
        result.add(name, reward.getValue());

        return result;
    }
}
