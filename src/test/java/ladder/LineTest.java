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
import ladder.domain.LineNumber;
import ladder.domain.Point;

public class LineTest {
    private ConnectStrategy connectStrategy;

    @BeforeEach
    void setUp() {
        connectStrategy = (connect) -> {
            if (connect) {
                return false;
            }
            return true;
        };
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
        List<Point> points = line.getPoint();

        // when & then
        for (int i = 0; i < input; i+=2) {
            assertThat(points.get(i).toBoolean()).isFalse();
        }
        for (int i = 1; i < input; i+=2) {
            assertThat(points.get(i).toBoolean()).isTrue();
        }
    }

    @Test
    void 라인_생성_테스트() {
        // given
        Line line = new Line(5, connectStrategy);
        List<Point> points = line.getPoint();
        List<Point> comparePoints = new ArrayList<Point>() {
            {
                add(Point.of(0, false));
                add(Point.of(1, true));
                add(Point.of(2, false));
                add(Point.of(3, true));
                add(Point.of(4, false));
            }
        };

        // when & then
        assertThat(points).isEqualTo(comparePoints);
    }

    @Test
    void 인덱스별_이동_테스트() {
        // given
        Line line = new Line(5, connectStrategy);
        List<Point> comparePoints = new ArrayList<Point>() {
            {
                add(Point.of(0, false));
                add(Point.of(1, true));
                add(Point.of(2, false));
                add(Point.of(3, true));
                add(Point.of(4, false));
            }
        };
        // when & then
        assertThat(line.matchPoint(LineNumber.valueOf(0))).isEqualTo(Point.of(1, true));
        assertThat(line.matchPoint(LineNumber.valueOf(1))).isEqualTo(Point.of(0, false));
        assertThat(line.matchPoint(LineNumber.valueOf(2))).isEqualTo(Point.of(3, true));
        assertThat(line.matchPoint(LineNumber.valueOf(3))).isEqualTo(Point.of(2, false));
        assertThat(line.matchPoint(LineNumber.valueOf(4))).isEqualTo(Point.of(4, false));
    }
}
