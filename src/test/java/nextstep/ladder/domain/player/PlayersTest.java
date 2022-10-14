package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("여러 이름으로 구성된 플레이어를 생성할 수 있다.")
    @Test
    void players() {
        Players players = Players.create("test1, test2, test3");

        assertThat(players.values()).containsExactly(new Player("test1"),
                new Player("test2"),
                new Player("test3"));
    }

    @DisplayName("중복된 이름의 플레이어는 제거된다.")
    @Test
    void duplicatedPlayers() {
        Players players = Players.create("test1, test1, test2, test3");

        assertThat(players.values()).hasSize(3)
                .containsExactly(new Player("test1"),
                        new Player("test2"),
                        new Player("test3"));
    }
}
