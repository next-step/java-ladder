package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("플레이어를 생성한다")
    void create() {
        Player actual = new Player("pobi");
        Player expected = new Player(new Name("pobi"));
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 이름을 출력한다")
    void name() {
        Player player = new Player("pobi");
        Name name = player.name();
        Assertions.assertThat(name).isEqualTo(new Name("pobi"));

    }
}
