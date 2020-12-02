package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderClimberTest {
    @Test
    @DisplayName("사디라 타는 객체 생성")
    void createLadderClimber() {
        Players players = Players.from("a,b,c");
        Lines lines = Lines.fromHeight(players.getSize(), 3, (point) -> true);
        LadderClimber ladderClimber = new LadderClimber(players, lines);
    }

    @Test
    @DisplayName("사다리 타기")
    void climb() {
        Players players = Players.from("a,b");
        Lines lines = Lines.fromHeight(players.getSize(), 2, (point) -> true);
        LadderClimber ladderClimber = new LadderClimber(players, lines);

        PlayersOnLines playersOnLines = ladderClimber.climb();

        PlayersOnLine firstPlayerOnLIne = new PlayersOnLine(players);
        PlayersOnLine secondPlayersOnLine = new PlayersOnLine(new Players(Arrays.asList(new Player("b"), new Player("a"))));
        PlayersOnLine thirdPlayersOnLine = new PlayersOnLine(new Players(Arrays.asList(new Player("a"), new Player("b"))));
        PlayersOnLines playersOnLinesExpected = new PlayersOnLines(Arrays.asList(firstPlayerOnLIne, secondPlayersOnLine, thirdPlayersOnLine));
        assertThat(playersOnLines).isEqualTo(playersOnLinesExpected);
    }
}
