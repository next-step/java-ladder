package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.exception.ShorterThanMinPositiveException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositiveTest {

    @DisplayName(Positive.MIN + " 미만의 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(ints = {Positive.MIN - 1, Positive.MIN - 100})
    void throwShorterThanMinPositiveException(final int rawPositive) {
        assertThatExceptionOfType(ShorterThanMinPositiveException.class)
                .isThrownBy(() -> Positive.valueOf(rawPositive));
    }

    @DisplayName("양수 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425})
    void equals(final int rawPositive) {
        // given
        final Positive positive = Positive.valueOf(rawPositive);
        final Positive expect = Positive.valueOf(rawPositive);

        // when
        final boolean equals = positive.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(positive == expect).isTrue();
    }
}