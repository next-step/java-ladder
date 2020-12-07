package ladder.model.name.wrapper;

import ladder.model.move.Point;
import ladder.model.name.Name;

public class Reward {
    private final Name name;
    private final Point point;

    private Reward(String name, Point point){
        this.name = Name.createRewardName(name);
        this.point = point;
    }

    public boolean match(Point point){
        return this.point.equals(point);
    }

    public static Reward of(String name, Point point){
        return new Reward(name, point);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
