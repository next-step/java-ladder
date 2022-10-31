package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {
    @DisplayName("사람 수와 높이에 맞는 사다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"4,5", "1,2"}, delimiter = ',')
    void lines(int countOfPerson, int height) {
        assertThat(new Ladder(countOfPerson, height).lines()).hasSize(height);
    }

    @DisplayName("사람 수 또는 높이가 1보다 작으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"0,5", "1,-1", "-1,0"}, delimiter = ',')
    void constructor_when_invalid_value(int countOfPerson, int height) {
        assertThatThrownBy(() -> new Ladder(countOfPerson, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of people or height is greater than 1.");
    }
}
