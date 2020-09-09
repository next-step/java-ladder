package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class PointTest {

    @ParameterizedTest
    @DisplayName("좌측 페달 여부 확인")
    @CsvSource(value = {"true,false,true", "false,true,false"})
    void hasLeftPedal(boolean leftPedal, boolean rightPedal, boolean expected) {
        then(Point.of(leftPedal, rightPedal).hasLeftPedal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("우측 페달 여부 확인")
    @CsvSource(value = {"true,false,false", "false,true,true"})
    void hasRightPedal(boolean leftPedal, boolean rightPedal, boolean expected) {
        then(Point.of(leftPedal, rightPedal).hasRightPedal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,false,1,0",
            "false,false,1,1",
            "false,true,1,2"
    })
    void play(boolean leftPedal, boolean rightPedal, int index, int expected) {
        Point point = Point.of(leftPedal, rightPedal);
        then(point.play(index)).isEqualTo(expected);
    }
}
