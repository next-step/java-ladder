package ladder.entity.ladderMap;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0x7fffffff})
    void canGeneratePoint(int input) {
        Point point = new Point(input);
        assertThat(point.index()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -0x80000000})
    void negativeInputThrowsException(int input) {
        CustomException thrown = assertThrows(CustomException.class, () -> new Point(input));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_POINT_INDEX);
    }
}
