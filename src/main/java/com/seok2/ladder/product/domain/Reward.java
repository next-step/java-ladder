package com.seok2.ladder.product.domain;

import com.seok2.ladder.structure.domain.Line;
import java.util.Objects;

public class Reward {

    private final Prize prize;
    private final Line line;

    public Reward(Prize prize, Line line) {
        this.prize = prize;
        this.line = line;
    }

    public static Reward of(Prize prize, Line line) {
        return new Reward(prize,line);
    }

    public boolean contain(Line line) {
        return this.line.equals(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reward)) {
            return false;
        }
        Reward reward = (Reward) o;
        return Objects.equals(prize, reward.prize) &&
            Objects.equals(line, reward.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, line);
    }
}
