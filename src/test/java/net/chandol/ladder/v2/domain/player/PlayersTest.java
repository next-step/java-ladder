package net.chandol.ladder.v2.domain.player;

import net.chandol.ladder.v2.domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PlayersTest {

    @Test
    public void 플레이어문자열확인() {
        Players players = Players.of("aaa", "bbb");

        String playersStr = players.createPlayersString();
        Assertions.assertThat(playersStr).isEqualTo(" aaa   bbb ");
    }
}
