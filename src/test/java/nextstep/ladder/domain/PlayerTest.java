package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("string을 매개변수로 player를 생성한다.")
    @Test
    void create() {
        String name = "pobi";
        Assertions.assertThat(Player.from(name)).isEqualTo(Player.from(name));
    }
}
