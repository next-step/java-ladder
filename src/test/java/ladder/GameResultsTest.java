package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    public void 플레이어리스트_결과리스트_초기상태_순서맞추기() {
        // given
        Players players = new Players("a,b,c,d");
        EndPoints endPoints = new EndPoints("에이,비,씨,디");
        // when
        GameResults gameResults = new GameResults(players, endPoints);
        // then
        Player player = players.match("a");
        assertThat(gameResults.getResult().get(player).name).isEqualTo("에이");
    }
}
