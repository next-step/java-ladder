package com.jaeyeonling.ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("위치 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_position_when_create_by_positionNumber(final int rawPosition) {
        // when
        final Position position = Position.valueOf(rawPosition);

        // then
        assertThat(position).isNotNull();
    }

    @DisplayName("위치가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_equalsObject_when_equalsPosition(final int rawPosition) {
        // given
        final Position position = Position.valueOf(rawPosition);
        final Position expect = Position.valueOf(rawPosition);

        // when
        final boolean equals = position.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(position == expect).isTrue();
    }

    @DisplayName("거리를 이동하면 현재 거리 + 이동 거리의 위치를 가진다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_sumPosition_when_move(final int rawPosition) {
        // given
        final Position position = Position.valueOf(rawPosition);
        final Distance movingDistance = Distance.valueOf(rawPosition);

        // when
        final Position movedPosition = position.move(movingDistance);
        final Position expect = Position.valueOf(rawPosition * 2);

        // then
        assertThat(movedPosition).isEqualTo(expect);
    }
}