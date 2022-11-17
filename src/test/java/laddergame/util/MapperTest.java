package laddergame.util;

import laddergame.domain.Name;
import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.domain.Result;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperTest {
    @Test
    void 맵_변환() {
        Players players = new Players(
                new Player("a", "1"),
                new Player("b", "2"),
                new Player("c", "3")
        );
        assertThat(Mapper.toMap(players)).isEqualTo(Map.of(
                new Name("a"), new Result("100"),
                new Name("b"), new Result("꽝"),
                new Name("c"), new Result("1000")));
    }
}
