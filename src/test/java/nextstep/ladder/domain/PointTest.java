package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        assertThat(Point.first(false)).isNotNull();
    }

    @DisplayName("첫번째 포인트를 생성한다. 길의 연결 여부에 따라 위치를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void first(boolean right, int index) {
        assertThat(Point.first(right).move()).isEqualTo(index);
    }

    @DisplayName("점의 이동을 테스트")
    @ParameterizedTest
    @CsvSource(value = {"false:true:2", "false:false:1", "true:false:0"}, delimiter = ':')
    void next(boolean first, boolean second, int index) {
        Point point = Point.first(first).next(second);
        assertThat(point.move()).isEqualTo(index);
    }
}
