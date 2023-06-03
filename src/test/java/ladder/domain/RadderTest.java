package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.domain.Line.MIN_WIDTH;
import static ladder.domain.Radder.MIN_HEIGHT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RadderTest {

    @Test
    void 생성검증() {
        Assertions.assertThat(Radder.of(4, 5)).isInstanceOf(Radder.class);
    }

    @Test
    void 높이검증() {
        assertThatThrownBy(() -> {
            Radder radder = Radder.of(1, 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
    }

    @Test
    void 넓이검증() {
        assertThatThrownBy(() -> {
            Radder radder = Radder.of(2, 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
    }

    @Test
    void 최종포지션검증() {



    }
}
