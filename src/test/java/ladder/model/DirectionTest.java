package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"false, false", "false, true", "true, false", "true, true"})
    @DisplayName("좌, 우 방향을 정상 입력하면 객체를 생성한다")
    void of(boolean isLeft, boolean isRight) {
        assertThat(Direction.of(isLeft, isRight)).isInstanceOf(Direction.class);
    }

}