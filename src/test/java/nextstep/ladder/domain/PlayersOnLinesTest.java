package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersOnLinesTest {

    @Test
    @DisplayName("마지막 PlayersOnLine객체 가져오기")
    void getLast() {
        Players players = new Players(Collections.singletonList(new Player("a")));
        PlayersOnLine firstPlayersOnLine = new PlayersOnLine(players);
        PlayersOnLine secondPlayersOnLine = new PlayersOnLine(players);
        PlayersOnLines playersOnLines = new PlayersOnLines(Arrays.asList(firstPlayersOnLine, secondPlayersOnLine));

        PlayersOnLine last = playersOnLines.getLast();

        assertThat(last).isEqualTo(secondPlayersOnLine);
    }
}