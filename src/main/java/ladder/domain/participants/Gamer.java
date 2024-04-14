package ladder.domain.participants;


import ladder.domain.ladders.LadderGame;
import ladder.domain.ladders.reward.Reward;
import ladder.domain.result.RewardResult;

import java.util.Objects;

public class Gamer {

    private final Name name;
    private final Position position;

    public Gamer(String name, int initPosition) {
        this(new Name(name), new Position(initPosition));
    }

    public Gamer(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public RewardResult climb(LadderGame ladder) {
        return new RewardResult(this.name, ladder.getRewardBy(position));
    }


    public boolean hasSameName(Name nameToFind) {
        return this.name.equals(nameToFind);
    }

    public boolean hasSamePosition(Reward reward) {
        return reward.isSamePosition(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name) && Objects.equals(position, gamer.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
