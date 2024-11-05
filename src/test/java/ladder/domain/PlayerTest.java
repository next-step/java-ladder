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

    @Test
    void name() {
        Player player = new Player("pobi");
        Name name = player.name();
        Assertions.assertThat(name).isEqualTo(new Name("pobi"));

    }
}
