package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author han
 */
class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 101123})
    @DisplayName("생성")
    void create(int number) {
        assertThat(new Height(number).getHeight()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("0보다 작으면 에러처리")
    void throwExceptionWhenLessThanZero(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Height(number));
    }
}