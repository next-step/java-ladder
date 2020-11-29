package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @DisplayName("생성")
    @Nested
    class Create {
        @DisplayName("성공")
        @Test
        void success() {
            // given
            final int index = 0;
            final Direction direction = Direction.valueOf(true, false);

            // when
            final Point point = Point.of(index, direction);

            // then
            assertThat(point).isNotNull();
        }

        @DisplayName("방향이 없는 경우")
        @Test
        void return_empty_point_when_no_direction() {
            // given
            final int index = 0;
            final Direction direction = Direction.valueOf(false, false);

            // when
            final Point point = Point.of(index, direction);

            // then
            assertThat(point).isNotNull();
        }
    }

    @DisplayName("다음 지점의 오른쪽 라인이 무조건 생성 되지 않도록 만들어 진 경우")
    @Test
    void when_generator_is_only_generate_none_direction() {
        // given
        final int index = 0;
        final Direction direction = Direction.valueOf(true, false);
        final Point point = Point.of(index, direction);

        // when
        final Point nextPoint = point.createNext(new DirectionGenerator() {
            @Override
            public Direction generateFirst() {
                return null;
            }

            @Override
            public Direction generateNext(Direction beforeDirection) {
                return Direction.NONE;
            }
        });

        // then
        assertThat(nextPoint.hasLeft()).isFalse();
        assertThat(nextPoint.hasRight()).isFalse();
    }

    @DisplayName("다음 지점의 오른쪽 라인이 무조건 생성 되도록 만들어 진 경우")
    @Test
    void when_generator_is_only_generate_right_result() {
        // given
        final int index = 0;
        final Direction direction = Direction.valueOf(false, false);
        final Point point = Point.of(index, direction);

        // when
        final Point nextPoint = point.createNext(new DirectionGenerator() {
            @Override
            public Direction generateFirst() {
                return null;
            }

            @Override
            public Direction generateNext(Direction beforeDirection) {
                return Direction.RIGHT;
            }
        });

        // then
        assertThat(nextPoint.hasLeft()).isFalse();
        assertThat(nextPoint.hasRight()).isTrue();
    }

    @DisplayName("기본 방향 제너레이터를 통해 Direction 만들기")
    @Test
    void crate_using_default_generator() {
        // given
        final int index = 0;
        final Direction direction = Direction.valueOf(false, false);
        final Point point = Point.of(index, direction);

        // when
        final Point nextPoint = point.createNext();

        // then
        assertThat(nextPoint).isNotNull();
    }

    @DisplayName("기본 방향 제너레이터를 통해 첫 번째 Direction 만들기")
    @Test
    void create_first_point_using_default_generator() {
        // when
        final Point nextPoint = Point.createFirst();

        // then
        assertThat(nextPoint).isNotNull();
    }

    @DisplayName("마지막 Point 만들기")
    @Test
    void create_last_point_using_default_generator() {
        // given
        final int index = 0;
        final Direction direction = Direction.valueOf(false, true);
        final Point point = Point.of(index, direction);

        // when
        final Point nextPoint = point.createLast();

        // then
        assertThat(nextPoint.hasLeft()).isTrue();
        assertThat(nextPoint.hasRight()).isFalse();
    }

    @DisplayName("오른쪽 사다리로 이동")
    @Test
    void move_right() {
        // given
        final int index = 0;
        final Direction direction = Direction.RIGHT;
        final Point point = Point.of(index, direction);

        // when
        final int afterMovePosition = point.move();

        // then
        assertThat(afterMovePosition).isEqualTo(index + 1);
    }

    @DisplayName("왼쪽 사다리로 이동")
    @Test
    void move_left() {
        // given
        final int index = 1;
        final Direction direction = Direction.LEFT;
        final Point point = Point.of(index, direction);

        // when
        final int afterMovePosition = point.move();

        // then
        assertThat(afterMovePosition).isEqualTo(index - 1);
    }

    @DisplayName("기존 사다리 유지")
    @Test
    void not_move() {
        // given
        final int index = 1;
        final Direction direction = Direction.NONE;
        final Point point = Point.of(index, direction);

        // when
        final int afterMovePosition = point.move();

        // then
        assertThat(afterMovePosition).isEqualTo(index);
    }
}
