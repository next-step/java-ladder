package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.model.Point.INVALID_POINT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @ParameterizedTest(name = "Point 객체 생성 - left, current의 값이 주어짐")
    @CsvSource(value = {"false:true:1", "true:false:-1", "false:false:0"}, delimiter = ':')
    void testPoint_withLeftAndCurrent(boolean left, boolean current, int movement) {
        // given
        Point point = Point.of(left, current);

        // when & then
        assertEquals(point.moveByDistance(), movement);
    }

    @Test
    @DisplayName("Point 객체 생성 실패 - 연달아 사다리가 이어진 포인트")
    void testPoint_connectedLeftAndCurrent_ShouldThrowException() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Point.of(true, true);
        }).withMessageContaining(INVALID_POINT);
    }

}
