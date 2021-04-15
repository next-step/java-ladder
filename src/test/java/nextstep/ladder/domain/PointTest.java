package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;
import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class PointTest {
    private Point pointWithRightDirection;
    private Point pointWithNone;
    private DirectionStrategy connectableTrueStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return true;
        }
    };

    private DirectionStrategy connectableFalseStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return false;
        }
    };

    @BeforeEach
    void setUp() {
        pointWithRightDirection = Point.first(connectableTrueStrategy);
        pointWithNone = Point.first(connectableFalseStrategy);
    }

    @Test
    @DisplayName("현재 좌표에서 연결 방향으로 이동한다.")
    public void move() throws Exception {
        assertThat(pointWithRightDirection.move()).isEqualTo(1);
        assertThat(pointWithNone.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("라인의 첫 번째 좌표를 생성한다.")
    public void first() throws Exception {
        Point rightDirectionPoint = Point.first(connectableTrueStrategy);
        Point noneDirectionPoint = Point.first(connectableFalseStrategy);

        assertThat(rightDirectionPoint).isEqualTo(pointWithRightDirection);
        assertThat(noneDirectionPoint).isEqualTo(pointWithNone);
    }

    @Test
    @DisplayName("라인의 마지막 좌표를 생성한다.")
    public void last() throws Exception {
        //when
        Point leftTrue = pointWithRightDirection.last();
        Point leftFalse = pointWithNone.last();

        then(leftTrue.hasLeftDirection()).isTrue();
        then(leftFalse.hasLeftDirection()).isFalse();
    }

    @Test
    @DisplayName("다음 좌표를 반환한다.")
    public void next() throws Exception {
        //when
        Point leftTrue = pointWithRightDirection.next(connectableFalseStrategy);
        Point allFalse = pointWithNone.next(connectableFalseStrategy);
        Point rightTrue = pointWithNone.next(connectableTrueStrategy);

        then(leftTrue.move()).isEqualTo(0);
        then(allFalse.move()).isEqualTo(1);
        then(rightTrue.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("오른쪽 방향을 가지고 있다면 참을 반환한다.")
    public void hasRightDirection() throws Exception {
        assertThat(pointWithRightDirection.hasRightDirection()).isTrue();
        assertThat(pointWithNone.hasRightDirection()).isFalse();
    }

    @Test
    @DisplayName("왼쪽 방향을 가지고 있다면 참을 반환한다.")
    public void hasLeftDirection() throws Exception {
        assertThat(pointWithRightDirection.hasLeftDirection()).isFalse();
        assertThat(pointWithNone.hasLeftDirection()).isFalse();
    }
}
