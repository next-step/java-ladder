package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.exception.EmptyLadderResultException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthLadderResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderResultTest {

    @DisplayName("결과 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "꽝",
            "5000",
            "꽝",
            "1000",
            "10100",
    })
    void should_return_ladderResult_when_create_by_ladderResult(final String rawLadderResult) {
        // when
        final LadderResult ladderResult = LadderResult.valueOf(rawLadderResult);

        // then
        assertThat(ladderResult).isNotNull();
    }

    @DisplayName("사다리 결과에 빈 값이나 null 값이 들어가면 실패한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_EmptyLadderResultException_when_create_by_emptyOrNullValue(final String nullAndEmptyValue) {
        assertThatExceptionOfType(EmptyLadderResultException.class)
                .isThrownBy(() -> {
                    LadderResult.valueOf(nullAndEmptyValue);
                });
    }

    @DisplayName("사다리 결과 길이가 " + LadderResult.MAX_LENGTH + " 를 넘는 값이 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void should_throw_LongerThanMaxLengthLadderResultException_when_create_by_longerThanMaxLengthUsername(
            final String longerThanMaxLengthLadderResult) {
        assertThatExceptionOfType(LongerThanMaxLengthLadderResultException.class)
                .isThrownBy(() -> {
                    LadderResult.valueOf(longerThanMaxLengthLadderResult);
                });
    }

    @DisplayName("당첨 결과가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "꽝",
            "1000",
            "10000",
            "ggg"
    })
    void should_equals_object_when_create_by_same_ladderResult(final String rawLadderResult) {
        // given
        final LadderResult ladderResult = LadderResult.valueOf(rawLadderResult);
        final LadderResult expect = LadderResult.valueOf(rawLadderResult);

        // when
        final boolean equals = ladderResult.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(ladderResult == expect).isTrue();
    }
}