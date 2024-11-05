package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void create() {
        Player actual = new Player("pobi");
        Player expected = new Player(new Name("pobi"));
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
