package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayersTest {
    @Test
    void 입력된_이름들로_Players를_생성한다() {
        String testPlayers = "  test1 ,test2,test3";
        Players players = Players.of(testPlayers);

        assertThat(players.getPlayers().size()).isEqualTo(3);
        assertThat(players.getPlayers().get(0).getName()).isEqualTo("test1");
    }

    @Test
    void 플레이어의_수가_2명_미만이면_예외가_발생한다() {
        String testPlayers = "test1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Players.of(testPlayers);
                });
    }
}
