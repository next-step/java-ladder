package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {
    @Test
    void create() {
        Players actual = new Players("pobi,crong,honux,jk");
        Players expected = new Players(List.of(
                        new Player("pobi"),
                        new Player("crong"),
                        new Player("honux"),
                        new Player("jk")));

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
