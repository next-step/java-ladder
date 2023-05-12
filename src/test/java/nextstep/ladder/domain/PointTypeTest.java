package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTypeTest {

    @CsvSource(value = {"false,false,NONE", "true,false,LEFT", "false,true,RIGHT"})
    @ParameterizedTest(name = "PointType 에서 left: {0}, right: {1} 이면 {2} 이다")
    void test01(boolean left, boolean right, PointType pointType) {
        PointType sut = PointType.findPointType(left, right);

        assertThat(sut).isEqualTo(pointType);
    }

    @CsvSource(value = {"NONE,0,0", "LEFT,0,-1", "RIGHT,0,1"})
    @ParameterizedTest(name = "PointType.{0} {1} 에서 이동하면 {2} 이다")
    void test02(PointType pointType, int position, int movedPosition) {
        Position sut = pointType.move(new Position(position));

        assertThat(sut).isEqualTo(new Position(movedPosition));
    }
}
