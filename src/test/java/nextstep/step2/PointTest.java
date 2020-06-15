package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Line;
import step2.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @RepeatedTest(10)
    @DisplayName("위치가 0일 때 왼쪽 값은 무조건 없도록(false) 나오는지 테스트")
    void checkfirstPoint(){
      Point point = Point.first();
      assertThat(point.left()).isFalse();
    }

    @ParameterizedTest
    @DisplayName("위치가 마지막일 때 오른쪽 값은 무조건 없도록(false) 나오는지 테스트")
    @CsvSource(value = {"3:2", "6:5", "7:6", "11:10"}, delimiter = ':')
    void checkLastPoint(int countOfperson, int lastPositionIndex){
        List<Point> points = Line.lineCreate(countOfperson);
        Point point = Point.last(points.get(lastPositionIndex));
        assertThat(point.right()).isFalse();
    }
}
