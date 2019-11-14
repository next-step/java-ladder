package com.seok2.ladder.product.domain;

import com.seok2.ladder.structure.domain.Layer;
import com.seok2.ladder.structure.domain.Pillar;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = Collections.unmodifiableList(rewards);
    }

    public static Rewards of(List<Reward> rewards) {
        return new Rewards(rewards);
    }

    public static Rewards of(Prizes prizes, Layer bottom) {
        return IntStream.range(0, prizes.size())
                .boxed()
                .map(idx -> Reward.of(prizes.get(idx), bottom.get(idx)))
                .collect(collectingAndThen(toList(), Rewards::of));
    }

    public Reward find(Pillar pillar) {
        return rewards.stream()
                .filter(p -> p.contain(pillar))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int size() {
        return rewards.size();
    }

}
