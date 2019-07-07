package ladderGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {


    private Players players;

    @BeforeEach
    void setUp() {
        players = Players.of(Arrays.asList("hello", "world", "nice"));
    }

    @Test
    @DisplayName("게임 참가자 수")
    public void create() {
        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("해당 position의 사용자 이름")
    public void getName() {
        assertThat(players.getPlayerName(new Position(1))).isEqualTo("world");
    }

    @Test
    @DisplayName("없는 범위의 Position 예외처리")
    void getResultException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            players.getPlayerName(new Position(4));
        });
    }


}