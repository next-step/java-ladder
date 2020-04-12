package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LadderTest {

    @DisplayName("사디리 생성 생성 테스트")
    @Test
    void testCreateLadder() {
        Ladder ladder = new Ladder(5, fourUsers());

        assertThat(ladder.getLines()).hasSize(5);
    }

    @DisplayName("사다리 높이 최소값 테스트")
    @Test
    void testMinimumHeight() {
        int height = 0;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, twoUsers()));
    }

    @DisplayName("최소 사용자 수 테스트")
    @Test
    void testMinimumUser() {
        int height = 1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(height, oneUsers()));
    }
}
