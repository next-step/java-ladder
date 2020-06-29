package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.point.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("플레이어 숫자가 2보다 작으면 예외 발생")
    @Test
    void createInvalidPlayer() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.create(1, new RandomPointGenerator()));
    }

    @DisplayName("point generator가 null이면 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.create(2, null));
    }

    @DisplayName("입력 플레이어 수만큼 point를 생성 반환")
    @Test
    void getConnects() {
        Line line = Line.create(10, new RandomPointGenerator());

        assertThat(line.getPoints()).hasSize(10);
    }

    @DisplayName("첫번째 포인트는 움직일 수 없음")
    @Test
    void getPointsFirstIndex() {
        Line line = Line.create(10, Point::first);

        assertThat(line.getPoints().get(0).isMovable()).isFalse();
    }


    @DisplayName("모든 포인트가 움직일 수 없는 경우")
    @Test
    void getPointsNotMove() {
        Line line = Line.create(2, Point::first);
        List<Point> points = line.getPoints();

        assertThat(points.get(0).isMovable()).isFalse();
        assertThat(points.get(1).isMovable()).isFalse();
    }

    @DisplayName("모든 포인트가 움직일 수 있는 경우")
    @Test
    void getPointsMoveAll() {
        Line line = Line.create(2, () -> Point.create(true));
        List<Point> points = line.getPoints();

        assertThat(points.get(0).isMovable()).isFalse();
        assertThat(points.get(1).isMovable()).isTrue();
    }

    @DisplayName("사다리 오른쪽으로 움직이면 Position 1이 증가")
    @Test
    void moveRight() {
        Line line = Line.create(2, () -> Point.create(true));
        Position position = line.move(Position.valueOf(0));

        assertThat(position).isEqualTo(Position.valueOf(1));
    }

    @DisplayName("사다리 왼쪽으로 움직이면 Position 1이 감소")
    @Test
    void moveLeft() {
        Line line = Line.create(2, () -> Point.create(true));
        Position position = line.move(Position.valueOf(1));

        assertThat(position).isEqualTo(Position.valueOf(0));
    }
}
