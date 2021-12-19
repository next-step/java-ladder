package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Point point = new Point(false);

        assertThat(point).isNotNull();
    }
    @DisplayName("점의 좌우 이동으로 다음 위치를 구하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"false:true:1", "true:false:-1", "false:false:0"}, delimiter = ':')
    void checkDirectionTest(boolean left, boolean current, int nextLocation) {
        Point leftPoint = new Point(left);
        Point currentPoint = new Point(current);

        assertThat(currentPoint.checkDirection(leftPoint)).isEqualTo(nextLocation);
    }
}
