package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderLineTest {
    int ladderSize = 4;

    @Test
    @DisplayName("init 을 통해 LadderLine 을 생성할 수 있다")
    void init() {
        LadderLine ladderLine = LadderLine.init(ladderSize);
        assertThat(ladderLine.size()).isEqualTo(ladderSize);
    }

    @Test
    @DisplayName("ladderSize 가 2 미만이면 에러")
    void initError() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LadderLine.init(1));
    }

    @Test
    @DisplayName("move 를 통해 사다리가 있는 경우는 알맞은 위치로 이동")
    void move() {
        List<Point> points = new ArrayList<>();
        Point firstPoint = Point.first(true);
        Point secondPoint = firstPoint.next(false);
        Point thirdPoint = secondPoint.next(true);
        Point lastPoint = thirdPoint.last();
        points.add(firstPoint);
        points.add(secondPoint);
        points.add(thirdPoint);
        points.add(lastPoint);
        LadderLine ladderLine = LadderLine.of(points);

        assertThat(ladderLine.move(0)).isEqualTo(1);
        assertThat(ladderLine.move(1)).isEqualTo(0);
        assertThat(ladderLine.move(2)).isEqualTo(3);
    }
}
