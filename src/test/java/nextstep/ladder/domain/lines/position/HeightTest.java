package nextstep.ladder.domain.lines.position;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HeightTest {

    @ParameterizedTest
    @DisplayName("최대 높이보다 작은지 확인한다.")
    @CsvSource(value = {"3, 4, true", "4, 4, false"})
    void compare_with_max_height(int given, int when, boolean expected) {
        // given
        Height height = new Height(given);

        // when
        boolean result = height.isLessThan(when);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
