package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @Test
    @DisplayName("사다리는 높이를 받아 저장할 수 있다.")
    void ladderCreateTest() {

        // given
        int input = 5;

        // when
        Ladder ladder = new Ladder(input);

        // then
        assertThat(ladder).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("사다리 생성 시 높이가 1보다 작은 값이 들어오면 Exception이 반환되어야 한다.")
    void ladderFailByLowHeightTest(int input) {

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Ladder(input))
            .withMessageMatching("사다리 높이는 0보다 큰 값만 들어와야 한다.");
    }

}