package ladder.domain;

import ladder.engine.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.domain.JerryLineCreator.MIN_WIDTH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class JerryLineCreatorTest {
    @Test
    void 생성검증() {
        Assertions.assertThat((new JerryLineCreator()).create(4)).isInstanceOf(Line.class);
    }

    @Test
    void width검증() {
        assertThatThrownBy(() -> {
            Assertions.assertThat((new JerryLineCreator()).create(1));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
    }
}
