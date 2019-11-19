package com.seok2.ladder.user.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.ladder.game.domain.Result;
import com.seok2.ladder.product.domain.Reward;
import com.seok2.ladder.product.domain.Rewards;
import com.seok2.ladder.structure.domain.Layer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players of(List<Player> players) {
        return new Players(players);
    }

    public static Players of(Participants participants, Layer top) {
        return IntStream.range(0, participants.size())
            .boxed()
            .map(idx -> Player.of(participants.get(idx), top.get(idx)))
            .collect(collectingAndThen(toList(), Players::of));
    }

    public Result match(Rewards rewards) {
        validate(rewards);
        Map<Player, Reward> result = new HashMap<>();
        players.forEach(player -> result.put(player, rewards.find(player.descend())));
        return Result.of(result);
    }

    public void validate(Rewards rewards) {
        if (players.size() != rewards.size()) {
            throw new IllegalArgumentException("참가자 수와 상품의 수는 다를 수 없습니다.");
        }
    }
}
