package ladder;

import ladder.domain.Name;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("라인이 없는 좌표 라인이 있는 좌표 생성 테스트")
    void create() {
        int x = 1;
        Point emptyPoint = Point.emptyPoint(x);
        Point filledPoint = Point.filledPoint(x);

        assertThat(emptyPoint.isEmpty()).isTrue();
        assertThat(filledPoint.isEmpty()).isFalse();
    }


//    @Test
//    @DisplayName("라인이 없는 좌표 라인이 있는 좌표 생성 테스트")
//    void create() {
//        int x = 0;
//        Point emptyPoint = Point.emptyPoint(x);
//        Point filledPoint = Point.filledPoint(x);
//
//        assertThat(emptyPoint.hasVerticalLine()).isTrue();
//        assertThat(filledPoint.hasVerticalLine()).isTrue();
//    }
//



}
