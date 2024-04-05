package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("전체 플레이어의 인원을 구한다.")
    @Test
    void test01() {
        Players players = new Players(List.of(PlayerTest.P1, PlayerTest.P2, PlayerTest.P3));
        assertThat(players.totalNumber()).isEqualTo(3);
    }
}
