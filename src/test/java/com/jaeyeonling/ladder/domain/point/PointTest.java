package com.jaeyeonling.ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @DisplayName("포인트 생성에 성공한다.")
    @Test
    void should_create() {
        // when
        final Point point = Point.of(1, 1);

        // then
        assertThat(point).isNotNull();
    }

    @DisplayName("LEFT로 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364
    })
    void should_return_movingPoint_when_move_by_LEFT(final int movingCount) {
        // given
        final Direction direction = Direction.LEFT;

        // when
        Point point = Point.DEFAULT;
        for (int i = 0; i < movingCount; i++) {
            point = point.move(direction);
        }
        final Point expect = Point.of(-movingCount, movingCount);

        // then
        assertThat(point).isEqualTo(expect);
    }

    @DisplayName("RIGHT로 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364
    })
    void should_return_movingPoint_when_move_by_RIGHT(final int movingCount) {
        // given
        final Direction direction = Direction.RIGHT;

        // when
        Point point = Point.DEFAULT;
        for (int i = 0; i < movingCount; i++) {
            point = point.move(direction);
        }
        final Point expect = Point.of(movingCount, movingCount);

        // then
        assertThat(point).isEqualTo(expect);
    }

    @DisplayName("STRAIGHT로 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364
    })
    void should_return_movingPoint_when_move_by_STRAIGHT(final int movingCount) {
        // given
        final Direction direction = Direction.STRAIGHT;

        // when
        Point point = Point.DEFAULT;
        for (int i = 0; i < movingCount; i++) {
            point = point.move(direction);
        }
        final Point expect = Point.of(0, movingCount);

        // then
        assertThat(point).isEqualTo(expect);
    }
}
