package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LaddersTest {

    @Test
    void 높이가_1미만이면_예외() {
        assertThatThrownBy(
                () -> new Ladders(2, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
