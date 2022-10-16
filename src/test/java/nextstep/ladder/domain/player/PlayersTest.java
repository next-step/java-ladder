package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("여러 이름으로 구성된 플레이어를 생성할 수 있다.")
    @Test
    void players() {
        Players players = Players.create("test1", "test2", "test3");

        assertThat(players.values()).containsExactly(Player.of("test1"),
                Player.of("test2"),
                Player.of("test3"));
    }

    @DisplayName("중복된 이름의 플레이어가 있으면 예외가 발생한다.")
    @Test
    void duplicatedPlayers() {

        assertThatThrownBy(() -> Players.create("test1", "test1", "test2", "test3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
