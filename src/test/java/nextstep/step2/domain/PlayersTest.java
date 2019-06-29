package nextstep.step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    @DisplayName("3명의 플레이어 생성")
    void create_players() {
        final var players = Players.create(List.of("choebk", "beomgyun", "nextstep"));
        assertThat(players.getPlayerCount()).isEqualTo(3);
    }
}
