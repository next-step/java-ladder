package com.seok2.ladder.product.domain;

import com.seok2.ladder.structure.domain.Pillar;
import java.util.Objects;

public class Reward {

    private final Prize prize;
    private final Pillar pillar;

    public Reward(Prize prize, Pillar pillar) {
        this.prize = prize;
        this.pillar = pillar;
    }

    public static Reward of(Prize prize, Pillar pillar) {
        return new Reward(prize, pillar);
    }

    public boolean contain(Pillar pillar) {
        return this.pillar.equals(pillar);
    }

    public Prize getPrize() {
        return prize;
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
            Objects.equals(pillar, reward.pillar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, pillar);
    }

}
