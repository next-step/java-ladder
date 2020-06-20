package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ladder.domain.Layer;
import ladder.domain.Point;
import ladder.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("첫번째 포인트 테스트")
    void checkfirstPoint(){
      Point point = Point.first(true);
      assertThat(point.getPosition()).isEqualTo(new Position(0));
      assertThat(point.left()).isFalse();
    }

    @ParameterizedTest
    @DisplayName("위치가 마지막일 때 오른쪽 값은 무조건 없도록(false) 나오는지 테스트")
    @CsvSource(value = {"3:2", "6:5", "7:6", "11:10"}, delimiter = ':')
    void checkLastPoint(int countOfperson){
        Layer layer = Layer.of(countOfperson);
        int lastIndex = countOfperson - 1;
        Point lastPoint = layer.getPoints().get(lastIndex);
        assertThat(lastPoint.right()).isFalse();
    }
}
