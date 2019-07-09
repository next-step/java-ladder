package com.jaeyeonling.ladder2.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class HeightOfLadderTest {

    @DisplayName("사다리 높이가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 5, 6, 8, 7, 6, 5, 100
    })
    void equals(final int rawHeightOfLadder) {
        // given
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(rawHeightOfLadder);
        final HeightOfLadder expect = HeightOfLadder.valueOf(rawHeightOfLadder);

        // when
        final boolean equals = heightOfLadder.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(heightOfLadder == expect).isTrue();
    }
}
