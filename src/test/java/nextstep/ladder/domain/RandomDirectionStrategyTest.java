package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomDirectionStrategyTest {

    DirectionStrategy directionStrategy;

    @Test
    @DisplayName("첫 인덱스일 때, Direction 오른쪽")
    void firstIndexRight() {
        Direction startDirection = directionStrategy.getStartDirection();
//        Direction direction = controller.decideDirection(null, 0, () -> 1);

        assertThat(startDirection).isEqualTo(Direction.RIGHT);
    }

//    @Test
//    @DisplayName("첫 인덱스일 때, Direction 직진")
//    void firstIndexForward() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(null, 0, () -> 0);
//
//        assertThat(direction).isEqualTo(Direction.FORWARD);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 오른쪽일 때, 다음 direction 왼쪽")
//    void nextDirectionLeft() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.RIGHT, 1, () -> 3);
//
//        assertThat(direction).isEqualTo(Direction.LEFT);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 왼쪽일 때, 다음 direction 직진")
//    void leftDirectionForward() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.LEFT, 2, () -> 0);
//
//        assertThat(direction).isEqualTo(Direction.FORWARD);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 왼쪽일 때, 다음 direction 오른쪽")
//    void leftDirectionRight() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.LEFT, 2, () -> 1);
//
//        assertThat(direction).isEqualTo(Direction.RIGHT);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 왼쪽일 때, 마지막 인덱스인 경우 직진")
//    void leftDirectionLastIndex() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.LEFT, -1, () -> 0);
//
//        assertThat(direction).isEqualTo(Direction.FORWARD);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 직진일 때, 다음 direction 직진")
//    void forwardDirectionForward() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.FORWARD, 2, () -> 0);
//
//        assertThat(direction).isEqualTo(Direction.FORWARD);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 직진일 때, 다음 direction 오른쪽")
//    void forwardDirectionRight() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.FORWARD, 2, () -> 1);
//
//        assertThat(direction).isEqualTo(Direction.RIGHT);
//    }
//
//    @Test
//    @DisplayName("이전 direction이 직진일 때, 마지막 인덱스인 경우 직진")
//    void forwardDirectionLastIndex() {
//        controller = new LadderController();
//
//        Direction direction = controller.decideDirection(Direction.FORWARD, -1, () -> 0);
//
//        assertThat(direction).isEqualTo(Direction.FORWARD);
//    }

}