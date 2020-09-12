package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 3", "3, 2"})
    @DisplayName("사다리 타기 : 다리가 있는 경우")
    void processLines(int point, int expected) {
        // given
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Lines lines = new Lines(3, 4, alwaysGenerateStrategy);

        // when
        int result = lines.processLines(point);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 2"})
    @DisplayName("사다리 타기 : 다리가 없는 경우")
    void processLines_does_not_have_steps(int point, int expected) {
        // given
        LadderGenerateStrategy alwaysDoNotGenerateStrategy = () -> false;
        Lines lines = new Lines(3, 3, alwaysDoNotGenerateStrategy);

        // when
        int result = lines.processLines(point);

        // then
        assertThat(result).isEqualTo(expected);
    }

}
