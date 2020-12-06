package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("첫 인덱스일 경우 직진")
    void firstIndexForward() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return Direction.FORWARD;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return null;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(null, 0, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("첫 인덱스일 경우 오른쪽")
    void firstIndexRight() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return Direction.RIGHT;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return null;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(null, 0, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전 인덱스가 오른쪽일 경우 왼쪽")
    void rightIndexLeft() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return Direction.LEFT;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(Direction.RIGHT, 2, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("이전 인덱스가 왼쪽일 경우 직진")
    void leftIndexForward() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return Direction.FORWARD;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(Direction.LEFT, 2, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 인덱스가 왼쪽일 경우 오른쪽")
    void leftIndexRight() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return Direction.RIGHT;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(Direction.LEFT, 2, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전 인덱스가 직진일 경우 직진")
    void forwardIndexForward() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return Direction.FORWARD;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(Direction.FORWARD, 2, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 인덱스가 직진일 경우 오른쪽")
    void forwardIndexRight() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return Direction.RIGHT;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(Direction.FORWARD, 2, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전 인덱스가 오른쪽일 경우 직진")
    void rightIndexForward() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return Direction.LEFT;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return null;
            }
        };

        Direction direction = Direction.decideDirection(Direction.RIGHT, 2, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("마지막 인덱스이고 이전 인덱스가 오른쪽일 경우, 왼쪽")
    void lastIndexLeft() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return null;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return Direction.LEFT;
            }
        };

        Direction direction = Direction.decideDirection(null, -1, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("마지막 인덱스이고 이전 인덱스가 직진일 경우, 직진")
    void lastIndexForward() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return null;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return Direction.FORWARD;
            }
        };

        Direction direction = Direction.decideDirection(Direction.FORWARD, -1, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("마지막 인덱스이고 이전 인덱스가 왼쪽일 경우, 직진")
    void leftLastIndexForward() {
        DirectionStrategy directionStrategy = new DirectionStrategy() {
            @Override
            public Direction getStartDirection() {
                return null;
            }

            @Override
            public Direction getNextDirection(Direction direction) {
                return null;
            }

            @Override
            public Direction getEndDirection(Direction direction) {
                return Direction.FORWARD;
            }
        };

        Direction direction = Direction.decideDirection(Direction.LEFT, -1, directionStrategy);
        Assertions.assertThat(direction).isEqualTo(Direction.FORWARD);
    }

}