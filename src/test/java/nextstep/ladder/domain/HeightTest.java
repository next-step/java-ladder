package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    void 높이가_1_이하이면_예외가_발생_한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Height(0));
    }

}
