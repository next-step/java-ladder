package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("라인 테스트")
class LineTest {

    @DisplayName("넓이가 유효하지 않으면 라인 객체 생성에 실패한다")
    @ParameterizedTest
    @CsvSource({"0", "-1", "-5"})
    void createLineWithInvalidCountOfPerson(int width) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(width))
                .withMessage("넓이가 유효하지 않습니다");
    }

    @DisplayName("넓이가 유효하면 라인 객체를 정상적으로 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createLine(int width) {
        Line line = new Line(width);
        Assertions.assertThat(line.fetchLines().size()).isEqualTo(width);
    }
}
