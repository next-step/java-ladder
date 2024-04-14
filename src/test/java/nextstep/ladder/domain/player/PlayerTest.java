package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayerTest {

    @DisplayName("참가자는 이름과 사다리에서의 index를 갖는다.")
    @Test
    void constructor() {
        assertThatCode(() -> new Player("pobi", 0))
                .doesNotThrowAnyException();
    }

    @DisplayName("equalsName은 참가자 이름이 특저 이름과 같은지 여부를 반환한다.")
    @Test
    void equalsName() {
        assertThat(new Player("pobi", 0).equalsName("pobi"))
                .isTrue();
    }

}
