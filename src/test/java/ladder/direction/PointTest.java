package ladder.direction;

import ladder.model.move.Direction;
import ladder.model.move.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {

    @Test
    public void 유저_위치(){
        assertThat(Point.userPoint(1)).isEqualTo(Point.of(2,0));
    }

    @Test
    public void 보상_위치(){
        assertThat(Point.rewardPoint(1,5)).isEqualTo(Point.of(2,5));
    }

    @Test
    public void 다리_위치(){
        assertThat(Point.bridgePoint(2, 1)).isEqualTo(Point.of(3,1));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Point.bridgePoint(0,0))
                .withMessageMatching("다리의 시작점은 0일 수 없습니다.");
    }

    @Test
    @DisplayName("이동 체크")
    public void move() {
        Point userPoint = Point.userPoint(1);
        assertThat(userPoint.move(Direction.LEFT)).isEqualTo(Point.of(0, 0));
        assertThat(userPoint.move(Direction.RIGHT)).isEqualTo(Point.of(4, 0));
        assertThat(userPoint.moveDown()).isEqualTo(Point.of(2, 1));
    }

    @Test
    public void 이동_가능(){
        Point userPoint = Point.userPoint(1);
        Point leftBridgePoint = Point.bridgePoint(1,0);
        Point rightBridgePoint = Point.bridgePoint(2,0);

        assertThat(Point.isMovable(userPoint, leftBridgePoint)).isTrue();
        assertThat(Point.isMovable(leftBridgePoint, userPoint)).isTrue();

        assertThat(Point.isMovable(userPoint, rightBridgePoint)).isTrue();
        assertThat(Point.isMovable(rightBridgePoint, userPoint)).isTrue();
    }

    @Test
    public void 이동_불가능(){
        Point userPoint = Point.userPoint(0);
        Point horizontalBridgePoint = Point.bridgePoint(2,0);
        Point verticalBridgePoint = Point.bridgePoint(1,1);

        assertThat(Point.isMovable(userPoint, horizontalBridgePoint)).isFalse();
        assertThat(Point.isMovable(horizontalBridgePoint, userPoint)).isFalse();

        assertThat(Point.isMovable(userPoint, verticalBridgePoint)).isFalse();
        assertThat(Point.isMovable(verticalBridgePoint, userPoint)).isFalse();
    }

    @Test
    @DisplayName("두 Point간 방향 체크")
    public void direction() {
        Point left = Point.userPoint(0);
        Point bridge = Point.bridgePoint(1,0);
        Point right = Point.userPoint(1);
        assertThat(Point.direction(left, bridge)).isEqualTo(Direction.RIGHT);
        assertThat(Point.direction(right, bridge)).isEqualTo(Direction.LEFT);
    }

    @Test
    public void 방향을_결정할_수_없는_경우(){
        Point left = Point.userPoint(0);
        Point right = Point.userPoint(1);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Point.direction(left, right))
                .withMessageMatching("방향을 찾을 수 없습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Point.direction(right, left))
                .withMessageMatching("방향을 찾을 수 없습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Point.direction(left, left))
                .withMessageMatching("방향을 찾을 수 없습니다.");

    }
}
