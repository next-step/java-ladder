package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.domain.ConnectStrategy;
import ladder.domain.Line;
import ladder.domain.Point;

public class LineTest {
    private ConnectStrategy connectStrategy;

    @BeforeEach
    void setUp() {
        connectStrategy = () -> true;
    }

    @Test
    void 생성자_테스트() {
        // given
        int countOfPerson = 5;
        Line line = new Line(countOfPerson, connectStrategy);
        // when & then
        assertThat(line).isEqualTo(new Line(countOfPerson, connectStrategy));
    }

    @Test
    void 참여자수_유효성_테스트() {
        // given
        int countOfPerson = 1;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Line(countOfPerson, connectStrategy));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "3", "4", "5"})
    void 라인_겹침_테스트(int input) {
        // given
        Line line = new Line(input, connectStrategy);
        List<Point> points = line.getPoints();

        // when & then
        for (int i = 0; i < input; i+=2) {
            assertThat(points.get(i).getConnection()).isFalse();
        }
        for (int i = 1; i < input; i+=2) {
            assertThat(points.get(i).getConnection()).isTrue();
        }
    }

    @Test
    void 라인_생성_테스트() {
        // given
        Line line = new Line(5, connectStrategy);
        List<Point> points = line.getPoints();
        List<Point> comparePoints = new ArrayList<Point>() {
            {
                add(Point.from(false));
                add(Point.from(true));
                add(Point.from(false));
                add(Point.from(true));
                add(Point.from(false));
            }
        };

        // when & then
        assertThat(points).isEqualTo(comparePoints);
    }
}
