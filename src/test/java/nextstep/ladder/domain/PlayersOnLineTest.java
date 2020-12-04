package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersOnLineTest {

    @Test
    @DisplayName("다음 플레이어와 교체")
    void swapWithNext() {
        Players players = new Players(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));
        PlayersOnLine playersOnLine = new PlayersOnLine(players);

        playersOnLine.swapWithNext(0);

        Players playersExpected = new Players(Arrays.asList(new Player("b"), new Player("a"), new Player("c")));
        PlayersOnLine playersOnLineExpected = new PlayersOnLine(playersExpected);
        assertThat(playersOnLine).isEqualTo(playersOnLineExpected);
    }
}