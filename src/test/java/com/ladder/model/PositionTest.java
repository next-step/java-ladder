package com.ladder.model;

import com.ladder.exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ladder.model.Position.MIN_NUMBER_OF_POSITION;
import static com.ladder.model.Position.MOVING_DISTANCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {

    @DisplayName("현 위치를 생성한다")
    @Test
    void createPosition_success() {
        // given
        int currentPosition = 0;

        // when
        Position result = Position.of(currentPosition);

        // then
        assertThat(result).isEqualTo(Position.of(currentPosition));
    }

    @DisplayName("현 위치가 " + MIN_NUMBER_OF_POSITION + "미만일 시 생성하는데 실패한다")
    @Test
    void createPosition_whenLessThanZero_exception() {
        // given
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> Position.of(-1));
    }

    @DisplayName("현 위치에서 앞으로 이동한다")
    @Test
    void moveForward_currentPosition_success() {
        // given
        int position = MIN_NUMBER_OF_POSITION;
        Position currentPosition = Position.of(position);

        // when
        Position movingResult = currentPosition.moveForward();

        // then
        assertThat(movingResult).isEqualTo(Position.of(position + MOVING_DISTANCE));
    }

    @DisplayName("현 위치에서 뒤로 이동한다")
    @Test
    void moveBackForward_currentPosition_success() {
        // given
        int position = MIN_NUMBER_OF_POSITION + 1;
        Position currentPosition = Position.of(position);

        // when
        Position movingResult = currentPosition.moveBackward();

        // then
        assertThat(movingResult).isEqualTo(Position.of(position - MOVING_DISTANCE));
    }
}