package nextstep.step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlayersTest {

    @Test
    @DisplayName("3명의 플레이어 생성")
    void create_players() {
        final var players = Players.create(List.of("choe", "bk", "next"));
        assertAll(
            () -> assertThat(players.getPlayerCount()).isEqualTo(3),
            () -> assertThat(players.getPlayers().get(0)).isEqualTo(new Player(0, "choe"))
        );
    }

    @Test
    @DisplayName("이름으로 플레이어 조회")
    void find_by_name() {
        final var players = Players.create(List.of("choe", "bk", "next"));
        assertThat(players.findByName("bk")).isEqualTo(new Player(1, "bk"));
    }
}
