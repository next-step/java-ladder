package com.seok2.ladder.structure.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.ladder.product.domain.Prizes;
import com.seok2.ladder.product.domain.Reward;
import com.seok2.ladder.product.domain.Rewards;
import com.seok2.ladder.user.domain.Participants;
import com.seok2.ladder.user.domain.Player;
import com.seok2.ladder.user.domain.Players;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Ladder {

    private final Deque<Layer> ladder;

    private Ladder(Deque<Layer> layers) {
        this.ladder = layers;
    }

    public static Ladder of(Height height, int width) {
        Deque<Layer> deque = new LinkedList<>();
        deque.push(Layer.bottom(width));
        for (int i = 0; i < height.intValue(); i++) {
            deque.push(deque.peek().build(new RandomBuildStategy()));
        }
        return new Ladder(deque);
    }

    private Layer getBottom() {
        return ladder.getLast();
    }

    private Layer getTop() {
        return ladder.getFirst();
    }

    public Deque<Layer> getLadder() {
        return ladder;
    }

    public Rewards putDown(Prizes prizes) {
        Layer bottom = getBottom();
        ladder.removeLast();
        return IntStream.range(0, prizes.size())
            .boxed()
            .map(idx -> Reward.of(prizes.get(idx), bottom.get(idx)))
            .collect(collectingAndThen(toList(), Rewards::of));
    }

    public Players grab(Participants participants) {
        Layer top = getTop();
        return IntStream.range(0, participants.size())
            .boxed()
            .map(idx -> Player.of(participants.get(idx), top.get(idx)))
            .collect(collectingAndThen(toList(), Players::of));

    }
}
