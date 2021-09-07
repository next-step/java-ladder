package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.WrongLadderSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderSizeTest {


    @ParameterizedTest
    @CsvSource(value = {"2,1", "2,2", "2,3"})
    @DisplayName("2 x 1 이상의 사다리 사이즈를 지정할수있다.")
    void rightLadderSize(int width, int height) {
        assertThatCode(() -> LadderSize.of(width, height))
            .doesNotThrowAnyException();
    }


    @ParameterizedTest
    @CsvSource(value = {"1,1", "1,0", "1,2", "0,1", "-1,-1"})
    @DisplayName("2 x 1 이하의 사다리 사이즈를 지정할경우 예외를 던진다.")
    void notRightLadderSize(int width, int height) {
        assertThatThrownBy(() -> LadderSize.of(width, height))
            .isInstanceOf(WrongLadderSizeException.class);
    }
}