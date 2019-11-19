package com.seok2.ladder.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.seok2.ladder.game.domain.Result;
import com.seok2.ladder.product.domain.Prize;
import com.seok2.ladder.product.domain.Reward;
import com.seok2.ladder.product.domain.Rewards;
import com.seok2.ladder.structure.domain.Pillar;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void match() {

        Pillar bottom = Pillar.of();
        Pillar top = bottom.build(null, (prv) -> null);

        Player player = Player.of(Participant.of("foo"), top);
        Players players = Players.of(Arrays.asList(player));

        Reward reward = Reward.of(Prize.of("bar"), bottom);
        Rewards rewards = Rewards.of(Arrays.asList(reward));

        Map<Player, Reward> map = new HashMap<>();
        map.put(player, reward);

        assertThat(players.match(rewards)).isEqualTo(Result.of(map));
    }
}