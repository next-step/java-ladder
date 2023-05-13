package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightInputTest {

    private static final int TEST_HEIGHT = 1;

    @Test
    @DisplayName("사용자 사다리 높이 입력되었을 경우 정상 객체를 생성한다.")
    void createObjTest() {
        assertDoesNotThrow(() -> new HeightInput(TEST_HEIGHT));
    }

    @Test
    @DisplayName("사용자가 입력한 높이에 따라 사다리 높이 객체를 반환한다.")
    void ladderHeightTest() {
        assertThat(new HeightInput(TEST_HEIGHT).ladderHeight())
                .isEqualTo(new LadderHeight(TEST_HEIGHT));
    }

}