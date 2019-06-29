package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.exception.ShorterThanMinPositiveException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveTest {

    @DisplayName("양수 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_positive_when_create_by_positiveNumber(final int lowPositive) {
        // when
        final Positive positive = Positive.valueOf(lowPositive);

        // then
        assertThat(positive).isNotNull();
    }

    @DisplayName("음수 값이 들어가면 실패한다.")
    @Test
    void should_throw_ShorterThanMinPositiveException_when_create_by_negativeNumber() {
        Assertions.assertThatExceptionOfType(ShorterThanMinPositiveException.class)
                .isThrownBy(() -> {
                    Positive.valueOf(-1);
                });
    }

    @DisplayName("양수 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 12, 3, 2432, 535643, 64, 563, 5236, 35364, 364526425
    })
    void should_return_equalsObject_when_equalsPositive(final int lowPositive) {
        // given
        final Positive positive = Positive.valueOf(lowPositive);
        final Positive expect = Positive.valueOf(lowPositive);

        // when
        final boolean equals = positive.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(positive == expect).isTrue();
    }
}