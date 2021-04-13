package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class PointTest {
    private Point pointWithRightDirection;
    private Point pointWithNone;

    @BeforeEach
    void setUp() {
        pointWithRightDirection = Point.first(() -> true);
        pointWithNone = Point.first(() -> false);
    }

    @Test
    @DisplayName("라인의 좌표와 방향을 인자로 받아 해당 좌표의 연결 상태를 나타내는 객체를 생성한다.")
    public void create() throws Exception {
        //given
        Point point = new Point(0, Direction.first(() -> true));
        Point unConnectedPoint = new Point(0, Direction.first(() -> false));

        //when
        boolean connected = point.isConnected();
        boolean unConnected = unConnectedPoint.isConnected();

        then(connected).isTrue();
        then(unConnected).isFalse();
    }

    @Test
    @DisplayName("현재 좌표에서 연결 방향으로 이동한다.")
    public void move() throws Exception {
        //given
        Point point = new Point(0, Direction.first(() -> true));

        //when
        int movedPoint = point.move();

        then(movedPoint).isEqualTo(1);
    }

    @Test
    @DisplayName("라인의 첫 번째 좌표를 생성한다.")
    public void first() throws Exception {
        Point point = Point.first(() -> true);
        assertThat(point).isEqualTo(new Point(0, Direction.first(() -> true)));
    }

    @Test
    @DisplayName("라인의 마지막 좌표를 생성한다.")
    public void last() throws Exception {
        //when
        Point leftTrue = pointWithRightDirection.last();
        Point leftFalse = pointWithNone.last();

        then(leftTrue).isEqualTo(new Point(1, new Direction(true, false)));
        then(leftFalse).isEqualTo(new Point(1, new Direction(false, false)));
    }

    @Test
    @DisplayName("다음 좌표를 반환한다.")
    public void next() throws Exception {
        //when
        Point leftTrue = pointWithRightDirection.next();
        Point allFalse = pointWithNone.next(() -> false);
        Point rightTrue = pointWithNone.next(() -> true);

        then(leftTrue).isEqualTo(new Point(1, new Direction(true, false)));
        then(allFalse).isEqualTo(new Point(1, new Direction(false, false)));
        then(rightTrue).isEqualTo(new Point(1, new Direction(false, true)));
    }

    @Test
    @DisplayName("오른쪽 방향을 가지고 있다면 참을 반환한다.")
    public void hasRightDirection() throws Exception {
        //when
        boolean rightTrue = pointWithRightDirection.hasRightDirection();
        boolean rightFalse = pointWithNone.hasRightDirection();

        //then
        then(rightTrue).isTrue();
        then(rightFalse).isFalse();
    }
}
