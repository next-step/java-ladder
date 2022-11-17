package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {
    @Test
    void 플레이어_수() {
        assertThat(new Players("a", "b", "c", "d").count()).isEqualTo(4);
    }

    @Test
    void name() {
        Ladder ladder = new Ladder(
                new Line(false, true),
                new Line(true, false)
        );
        Results results = new Results(List.of("1000", "100", "꽝"));
        Players players = new Players("a", "b", "c");

        players.executeGame(ladder, results);

        assertThat(players.getPlayers()).contains(
                new Player("a", "100"),
                new Player("b", "꽝"),
                new Player("c", "1000")
        );
    }
}
