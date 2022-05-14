package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {

    @Test
    @DisplayName("사다리의 높이는 1보다 작을 수 없습니다.")
    void ladderHeightException() {
        assertThrows(NullPointerException.class, () -> {
            new Height(0);
        });
    }
}