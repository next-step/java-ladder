package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.exception.EmptyLadderRewordException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthLadderRewordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderRewordTest {

    @DisplayName("결과 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "꽝",
            "5000",
            "꽝",
            "1000",
            "10100",
    })
    void should_return_ladderReword_when_create_by_ladderReword(final String rawLadderReword) {
        // when
        final LadderReword ladderReword = LadderReword.valueOf(rawLadderReword);

        // then
        assertThat(ladderReword).isNotNull();
    }

    @DisplayName("사다리 결과에 빈 값이나 null 값이 들어가면 실패한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_EmptyLadderRewordException_when_create_by_emptyOrNullValue(final String nullAndEmptyValue) {
        assertThatExceptionOfType(EmptyLadderRewordException.class)
                .isThrownBy(() -> {
                    LadderReword.valueOf(nullAndEmptyValue);
                });
    }

    @DisplayName("사다리 결과 길이가 " + LadderReword.MAX_LENGTH + " 를 넘는 값이 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void should_throw_LongerThanMaxLengthLadderRewordException_when_create_by_longerThanMaxLengthLadderReword(
            final String longerThanMaxLengthLadderReword) {
        assertThatExceptionOfType(LongerThanMaxLengthLadderRewordException.class)
                .isThrownBy(() -> {
                    LadderReword.valueOf(longerThanMaxLengthLadderReword);
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
    void should_equals_object_when_create_by_same_ladderReword(final String rawLadderReword) {
        // given
        final LadderReword ladderReword = LadderReword.valueOf(rawLadderReword);
        final LadderReword expect = LadderReword.valueOf(rawLadderReword);

        // when
        final boolean equals = ladderReword.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(ladderReword == expect).isTrue();
    }
}