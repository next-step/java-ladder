package nextstep.ladder.domain.point;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @DisplayName("사다리가 연속적으로 존재하지 않으면 유효하다.")
    @ParameterizedTest
    @CsvSource(value = {
        "false,true",
        "false,false",
        "true,false"
    })
    void isValidLadder(boolean pre, boolean current) {
        Point prePoint = Point.first(()->pre);
        Point currentPoint = prePoint.next(()->current);

        assertThat(currentPoint.isValid(prePoint)).isEqualTo(true);
    }

    @DisplayName("사다리가 연속적으로 존재하면 유효하지 않다.")
    @Test
    void isInValidLadder() {
        Point prePoint = Point.first(()->true);
        Point currentPoint = Point.first(()->true);

        assertThat(currentPoint.isValid(prePoint)).isEqualTo(false);
    }

}
