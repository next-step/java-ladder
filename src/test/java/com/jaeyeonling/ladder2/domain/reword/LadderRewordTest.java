package com.jaeyeonling.ladder2.domain.reword;

import com.jaeyeonling.ladder2.exception.EmptyLadderRewordException;
import com.jaeyeonling.ladder2.exception.LongerThanMaxLengthLadderRewordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderRewordTest {

    @DisplayName("사다리 결과에 빈 값이나 null 값이 들어가면 실패한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void throwEmptyLadderRewordException(final String nullAndEmptyValue) {
        assertThatExceptionOfType(EmptyLadderRewordException.class)
                .isThrownBy(() -> LadderReword.valueOf(nullAndEmptyValue));
    }

    @DisplayName("사다리 결과 길이가 " + LadderReword.MAX_LENGTH + " 를 넘는 값이 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void throwLongerThanMaxLengthLadderRewordException(
            final String longerThanMaxLengthLadderReword) {
        assertThatExceptionOfType(LongerThanMaxLengthLadderRewordException.class)
                .isThrownBy(() -> LadderReword.valueOf(longerThanMaxLengthLadderReword));
    }

    @DisplayName("당첨 결과가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "꽝",
            "1000",
            "10000",
            "ggg"
    })
    void equals(final String rawLadderReword) {
        // given
        final LadderReword ladderReword = LadderReword.valueOf(rawLadderReword);
        final LadderReword expect = LadderReword.valueOf(rawLadderReword);

        // when
        final boolean equals = ladderReword.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(ladderReword == expect).isTrue();
    }

    @DisplayName("시각화 시 입력과 같은 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg",
            "다섯글자다"
    })
    void equalsVisualize(final String rawLadderReword) {
        // given
        final LadderReword ladderReword = LadderReword.valueOf(rawLadderReword);

        // when
        final String visualized = ladderReword.visualize();

        // then
        assertThat(visualized).isEqualTo(rawLadderReword);
    }
}