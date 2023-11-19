package nextstep.ladder.domain;

import nextstep.ladder.dto.Height;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    @DisplayName("높이가 0 이하이면 예외가 발생 한다")
    void newHeight() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Height(0));
    }

}
