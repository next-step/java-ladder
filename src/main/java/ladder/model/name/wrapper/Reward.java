package ladder.model.name.wrapper;

import ladder.model.name.Name;

public class Reward {
    private final Name name;

    private Reward(String name){
        this.name = Name.createRewardName(name);
    }

    public static Reward of(String name){
        return new Reward(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
