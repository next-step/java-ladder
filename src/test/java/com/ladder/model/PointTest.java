package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static com.ladder.model.Point.INDEX_OF_FIRST;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("위치와 방향을 가지는 포인트를 생성한다")
    @ParameterizedTest
    @CsvSource({
            "0, LEFT",
            "1, RIGHT",
            "2, DOWN"
    })
    void createPoint_success(int indexOfLadder, Direction direction) {
        // when
        Point result = Point.of(indexOfLadder, direction);

        // then
        assertThat(result).isEqualTo(Point.of(indexOfLadder, direction));
    }

    @DisplayName("첫번째 위치를 생성하는데 성공한다")
    @ParameterizedTest
    @EnumSource(value = Direction.class, names = {"RIGHT", "DOWN"})
    void createFirst_inputOne_success(Direction direction) {
        // given
        int indexOfIndex = INDEX_OF_FIRST;

        // when
        Point result = Point.ofFirst(direction);

        // then
        assertThat(result).isEqualTo(Point.of(indexOfIndex, direction));
    }

    @DisplayName("다음 위치 값을 생성하는데 성공한다")
    @ParameterizedTest
    @CsvSource({
            "'DOWN', 'RIGHT'",
            "'RIGHT', 'LEFT'"
    })
    void createNext_inputCurrentDirection_success(Direction before, Direction currentDirection) {
        // given
        Point firstPoint = Point.ofFirst(before);

        // when
        Point result = firstPoint.next(currentDirection);

        // then
        assertThat(result).isEqualTo(Point.of(INDEX_OF_FIRST + 1, currentDirection));
    }

    @DisplayName("마지막 위치를 생성하는데 성공한다")
    @ParameterizedTest
    @CsvSource({
            "'DOWN', 'DOWN'",
            "'RIGHT', 'LEFT'"
    })
    void createLast_success(Direction before, Direction expectedDirection) {
        // given
        Point point = Point.ofFirst(before);

        // when
        Point result = point.last();

        // then
        assertThat(result).isEqualTo(Point.of(INDEX_OF_FIRST + 1, expectedDirection));
    }
}