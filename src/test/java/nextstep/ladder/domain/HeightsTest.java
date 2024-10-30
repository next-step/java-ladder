package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightsTest {


    @Test
    void 높이가_1미만이면_예외() {
        assertThatThrownBy(
                () -> new Heights(2, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
