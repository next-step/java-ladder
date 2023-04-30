package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HeightsTest {

    @Test
    @DisplayName("사다리 높이 객체 생성 테스트")
    void createHeights() {
        Heights heights = new Heights(5);

        assertThat(heights)
                .isInstanceOf(Heights.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("0보다 작은 수일 때 에러 테스트")
    void belowZeroErrorTest(int input) {
        assertThatThrownBy(() -> new Heights(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}