package com.jaeyeonling.ladder.domain;

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
    void should_return_position_when_create_by_positionNumber(final int lowPosition) {
        // when
        final Position position = Position.valueOf(lowPosition);

        // then
        assertThat(position).isNotNull();
    }

    @DisplayName("위치가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_equalsObject_when_equalsPosition(final int lowPosition) {
        // given
        final Position position = Position.valueOf(lowPosition);
        final Position expect = Position.valueOf(lowPosition);

        // when
        final boolean equals = position.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(position == expect).isTrue();
    }
}