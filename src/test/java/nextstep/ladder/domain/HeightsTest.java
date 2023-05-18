package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("높이 생성 테스트")
    void createHeightsTest(int input) {
        Heights heights = new Heights(input);

        assertThat(heights.getHeights())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    @DisplayName("높이가 0보다 작거나 같을 때 에러 반환 테스트")
    void lowerThenEqualZeroErrorTest(int input) {
        assertThatThrownBy(() -> new Heights(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
