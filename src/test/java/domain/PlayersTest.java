package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("전체 플레이어의 인원을 구한다.")
    @Test
    void test01() {
        Player player1 = new Player("pobi");
        Player player2 = new Player("honux");
        Player player3 = new Player("crong");
        Players players = new Players(List.of(player1, player2, player3));

        assertThat(players.totalNumber()).isEqualTo(3);
    }
}
