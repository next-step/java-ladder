package nextstep.ladder2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {
    @DisplayName("왼쪽/오른쪽 이동 가능한지를 표현한다")
    @Test
    void create() {
        assertAll(
                () -> assertThat(Direction.of(true, false))
                        .isEqualTo(Direction.of(true, false)),
                () -> assertThat(Direction.of(false, true))
                        .isEqualTo(Direction.of(false, true)),
                () -> assertThat(Direction.of(false, false))
                        .isEqualTo(Direction.of(false, false))
        );
    }

    @DisplayName("양쪽으로 이동을 불가능하다")
    @Test
    void illegal_state() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("좌측 끝지점은 왼쪽으로 이동이 불가능하다")
    @Test
    void first() {
        assertThat(Direction.first(true).isLeft()).isFalse();
    }

    @DisplayName("좌측 끝지점은 오른쪽 이동가능여부를 받는다")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void firstAcceptRightMovable(boolean rightMovable) {
        assertThat(Direction.first(rightMovable).isRight()).isEqualTo(rightMovable);
    }

    @DisplayName("우측 끝지점은 오른쪽 이동이 불가능하다")
    @Test
    void last() {
        assertThat(Direction.first(false).last().isRight()).isFalse();
    }

    @DisplayName("우측 끝지점의 왼쪽 이동가능여부는 이전지점의 오른쪽 이동가능여부와 같다")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void lastUsePreviousValue(boolean rightMoveable) {
        Direction first = Direction.first(rightMoveable);
        assertThat(first.last().isLeft()).isEqualTo(first.isRight());
    }

    @DisplayName("이전지점으로 부터 다음 지점을 제공한다")
    @Test
    void next() {
        assertThat(Direction.first(false).next(true)).isEqualTo(Direction.of(false, true));
    }

    @DisplayName("이전지점에서 오른쪽으로 이동가능한 경우 다음지점은 오른쪽으로 이동 불가능하다")
    @Test
    void next_illegal_state() {
        assertThatThrownBy(() -> Direction.first(true).next(true))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("다음 지점의 왼쪽 이동가능여부는 이전지점의 오른쪽 이동가능여부와 같다")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void nextUsePreviousValue(boolean rightMoveable) {
        Direction first = Direction.first(rightMoveable);
        assertThat(first.next(false).isLeft()).isEqualTo(first.isRight());
    }

    private static class Direction {
        private static final Direction LEFT = new Direction(true, false);
        private static final Direction RIGHT = new Direction(false, true);
        private static final Direction NEUTRAL = new Direction(false, false);
        private final boolean left;
        private final boolean right;

        public Direction(boolean left, boolean right) {
            this.left = left;
            this.right = right;
        }

        public static Direction of(boolean left, boolean right) {
            if (left && right) {
                throw new IllegalStateException();
            }
            if (left) {
                return LEFT;
            }
            if (right) {
                return RIGHT;
            }
            return NEUTRAL;
        }

        public static Direction first(boolean right) {
            return of(false, right);
        }

        public Direction last() {
            return of(right, false);
        }

        public Direction next(boolean right) {
            return of(this.right, right);
        }

        public boolean isLeft() {
            return left;
        }

        public boolean isRight() {
            return right;
        }
    }
}
