package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
        List<String> result = List.of("1000", "100", "꽝");

        assertThat(new Players("a", "b", "c").startGame(ladder, result))
                .isEqualTo(new TotalResult(Map.of(
                        new Player("a"), new Result("100"),
                        new Player("b"), new Result("꽝"),
                        new Player("c"), new Result("1000")))
                );
    }
}
