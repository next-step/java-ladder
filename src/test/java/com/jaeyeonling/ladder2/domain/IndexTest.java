package com.jaeyeonling.ladder2.domain;

import com.jaeyeonling.ladder2.exception.ShorterThanMinPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class IndexTest {

    @DisplayName("위치 값을 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6, 8, 8, 5675, 56, 54, 456, 45, 53, 5235, 412})
    void increment(final int rawIndex) {
        // given
        final Index index = Index.valueOf(rawIndex);

        // when
        final Index incrementedIndex = index.increment();
        final Index expected = Index.valueOf(rawIndex + Index.INCREMENT_VALUE);

        // then
        assertThat(incrementedIndex).isEqualTo(expected);
    }

    @DisplayName("위치 값을 감소시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6, 8, 8, 5675, 56, 54, 456, 45, 53, 5235, 412})
    void decrement(final int rawIndex) {
        // given
        final Index index = Index.valueOf(rawIndex);

        // when
        final Index decrementedIndex = index.decrement();
        final Index expected = Index.valueOf(rawIndex - Index.INCREMENT_VALUE);

        // then
        assertThat(decrementedIndex).isEqualTo(expected);
    }

    @DisplayName("위치 값이 " + Index.MIN + "보다 적으면 예외처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {Index.MIN - 1})
    void throwShorterThanMinPositionException(final int rawIndex) {
        assertThatExceptionOfType(ShorterThanMinPositionException.class)
                .isThrownBy(() -> Index.valueOf(rawIndex));
    }

    @DisplayName("같은 값을 가지면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6, 8, 8, 5675, 56, 54, 456, 45, 53, 5235, 412})
    void equals(final int rawIndex) {
        // given
        final Index index = Index.valueOf(rawIndex);
        final Index expected = Index.valueOf(rawIndex);

        // when
        final boolean equals = index.equals(expected);

        // then
        assertThat(equals).isTrue();
        assertThat(index == expected).isTrue();
    }
}
