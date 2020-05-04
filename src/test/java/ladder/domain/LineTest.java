package ladder.domain;

import ladder.domain.exception.InvalidCountOfPersonException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4})
    @DisplayName("주어진 사람 수 만큼의 라인 생성 확인")
    public void generateLintTest(int countOfPerson) {
        Line line = Line.init(countOfPerson);

        assertThat(line.isCountOfPerson(countOfPerson)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0})
    @DisplayName("유효하지 않은 사람수 입력 시 InvalidCountOfPersonException 발생")
    public void movePositionSuccess(int countOfPerson) {
        assertThatExceptionOfType(InvalidCountOfPersonException.class).isThrownBy(
                () -> Line.init(countOfPerson)
        );
    }
}
