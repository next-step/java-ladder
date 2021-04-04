package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.domain.Line;
import ladder.domain.Point;

public class LineTest {

    @Test
    void 생성자_테스트() {
        // given
        int countOfPerson = 5;
        Line line = new Line(countOfPerson);
        // when & then
        assertThat(line).isEqualTo(new Line(countOfPerson));
    }

    @Test
    void 참여자수_유효성_테스트() {
        // given
        int countOfPerson = 1;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Line(countOfPerson));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "3", "4", "5"})
    void 라인_겹침_테스트(int input) {
        // given
        Line line = new Line(input);
        line.draw(() -> true);
        List<Point> points = line.getPoints();

        // when & then
        for (int i = 0; i < input; i++) {
            if (i % 2 == 1) {
                assertThat(points.get(i).getConnection()).isTrue();
            }
            if (i % 2 == 0) {
                assertThat(points.get(i).getConnection()).isFalse();
            }
        }
    }
}
