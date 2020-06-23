package ladder.domain.reward;

import ladder.domain.player.Name;

import java.util.Objects;
import java.util.Optional;

public class Reward {

    private final Name name;

    private Reward(Name name) {
        this.name = Optional.ofNullable(name)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Reward create(Name name) {
        return new Reward(name);
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
