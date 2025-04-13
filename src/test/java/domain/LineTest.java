package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    @DisplayName("라인의 포인트 개수는 열의 개수 - 1 만큼 생성된다.")
    void 라인_생성_테스트() {
        Line line = new Line(5, new RandomConnectionStrategy());
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("짝수 위치에만 가로줄이 생성된다.")
    void 라인_고정_생성_테스트() {
        Line line = new Line(5, new FixedConnectionStrategy());
        List<Boolean> points = line.getPoints();

        for (int i = 0; i < points.size(); i++) {
            if (i % 2 == 0) {
                assertThat(points.get(i)).isTrue();
            } else {
                assertThat(points.get(i)).isFalse();
            }
        }
    }
}
