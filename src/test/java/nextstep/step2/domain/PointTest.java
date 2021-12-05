package nextstep.step2.domain;

import nextstep.step2.vo.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void createTest() {
        Point intToPoint = Point.from(1);
        Point pointToPoint = Point.fromWithPoint(intToPoint);
        assertThat(intToPoint).isEqualTo(pointToPoint);
        assertThat(intToPoint).isEqualTo(intToPoint);
    }

    @DisplayName("Move(Bridge) 호출 시 위치 값 변화시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"DOWN:1", "LEFT:0", "RIGHT:2"}, delimiter = ':')
    void left(String bridgeName, int expectPoint) {
        Point point = Point.from(1);

        assertThat(point.movedPoint(Bridge.valueOf(bridgeName))).isEqualTo(Point.from(expectPoint));
    }

}
