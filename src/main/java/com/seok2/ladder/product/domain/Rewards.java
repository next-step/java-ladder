package com.seok2.ladder.product.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.ladder.structure.domain.Layer;
import com.seok2.ladder.structure.domain.Line;
import com.seok2.ladder.user.domain.Participants;
import java.util.Collections;
import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = Collections.unmodifiableList(rewards);
    }

    public static Rewards of(List<Reward> rewards) {
        return new Rewards(rewards);
    }

    public static Rewards of(Prizes prizes, Layer bottom) {
        return prizes.stream()
            .flatMap(prize -> bottom.stream()
                .map(line -> Reward.of(prize,line))
            ).collect(collectingAndThen(toList(), Rewards::of));
    }

    public Reward find(Line line) {
        return rewards.stream()
            .filter(p -> p.contain(line))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public int size() {
        return rewards.size();
    }

}
