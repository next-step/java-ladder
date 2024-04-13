package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayerTest {

    @DisplayName("참가자는 이름과 사다리에서의 index를 갖는다.")
    @Test
    void constructor() {
        assertThatCode(() -> new Player("pobi", 0))
                .doesNotThrowAnyException();
    }

}
