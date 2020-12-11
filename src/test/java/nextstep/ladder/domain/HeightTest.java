package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    @DisplayName("최대 사다리 높이 입력 시 1 이상이 아닐 경우 예외처리")
    void checkHeightValidate() {
        int height = 0;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Height.from(height)
        );
    }

}