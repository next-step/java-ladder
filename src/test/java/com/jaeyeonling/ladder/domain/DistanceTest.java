package com.jaeyeonling.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("거리 생성에 성공한다.")
    @Test
    void should_create() {
        final Distance distance = Distance.valueOf(1);

        assertThat(distance).isNotNull();
    }

    @DisplayName("거리가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_equalsObject_when_equalsDistance(final int lowDistance) {
        // given
        final Distance distance = Distance.valueOf(lowDistance);
        final Distance expect = Distance.valueOf(lowDistance);

        // when
        final boolean equals = distance.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(distance == expect).isTrue();
    }
}
