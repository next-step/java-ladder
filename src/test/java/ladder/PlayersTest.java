package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    void 입력된_이름들로_Players를_생성한다() {
        String testPlayers = "  test1 ,test2,test3";
        Players players = Players.of(testPlayers);

        assertThat(players.getPlayers().size()).isEqualTo(3);
        assertThat(players.getPlayers().get(0).getName()).isEqualTo("test1");
    }
}
