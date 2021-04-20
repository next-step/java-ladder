package ladder;

import ladder.domain.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    public void getAllPlayerTest() {
        //given
        String expectEdge = "a      b      c      d      ";
        Players players = Players.valueOf(Arrays.asList("a", "b", "c", "d"));

        //when
        String resultEdge = players.getAllPlayer();

        //then
        assertThat(resultEdge).isEqualTo(expectEdge);
    }
}
