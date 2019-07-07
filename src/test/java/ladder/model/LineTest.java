package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 생성에 사용될 가로 라인 생성 테스트")
    void createLine() {
        Line lines = Line.lineSet(5);
        List<Point> points = lines.getPoints();
        for(Point point : points){
            assertThat(
            point.getStatusOfPoint().isLeft()
                   && point.getStatusOfPoint().isRight()
            ).isFalse();
        }
    }

}
