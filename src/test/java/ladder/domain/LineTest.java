package ladder.domain;

import ladder.exception.LineCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @ParameterizedTest
    @DisplayName("사다리 라인 생성 예외 테스트")
    @ValueSource(ints = {0, -1})
    void lineException(int countOfPerson) {
        assertThatThrownBy(() -> new Line(countOfPerson))
                .isInstanceOf(LineCountException.class);
    }

    @ParameterizedTest
    @DisplayName("라인 생성 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createLine(int countOfPerson) {
        Line line = new Line(countOfPerson);
        int actual = line.getPoints().size();
        int expected = countOfPerson;
        assertThat(actual).isEqualTo(expected);
    }
}