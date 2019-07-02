package com.jaeyeonling.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("isNullOrEmpty에 null 이나 빈 값을 입력 시 true를 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void should_return_true_when_isNullOrEmpty_by_nullOrEmptyValue(final String nullOrEmptyValue) {
        // when
        final boolean isNullOrEmpty = StringUtils.isNullOrEmpty(nullOrEmptyValue);

        // then
        assertThat(isNullOrEmpty).isTrue();
    }

    @DisplayName("오른쪽 정렬 시 정렬이 되야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "asda", "sdfsdf", "asfsdfsd", "e23r32f", "dsvsdfsdsds",
            "sdvsdvsds", "dvsdwwe", "a", "23gr3eggre23erthge3r4er"
    })
    void should_return_rightAlignString_when_rightAlign(final String string) {
        // given
        final int paddingLength = 10;

        // when
        final String alignString = StringUtils.rightAlign(string, string.length() + paddingLength);
        final String expect = " ".repeat(paddingLength) + string;

        // then
        assertThat(alignString).isEqualTo(expect);
    }

    @DisplayName("오른쪽 정렬 후 trim 시 입력과 같은 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "asda", "sdfsdf", "asfsdfsd", "e23r32f", "dsvsdfsdsds",
            "sdvsdvsds", "dvsdwwe", "a", "23gr3eggre23erthge3r4er"
    })
    void should_equals_rightAlignString_and_trimString(final String string) {
        // when
        final String alignString = StringUtils.rightAlign(string, string.length() + 10);

        // then
        assertThat(alignString.trim()).isEqualTo(string);
    }

    @DisplayName("길이 초과 확인 시 입력한 문자열 길이와 같은 길이를 입력하면 false를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void should_return_false_when_isOverLength_by_stringLength(final String string) {
        final boolean isOverLength = StringUtils.isOverLength(string, string.length());

        assertThat(isOverLength).isFalse();
    }
    @DisplayName("길이 초과 확인 시 입력한 문자열 길이보다 작은 길이를 입력하면 true를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void should_return_true_when_isOverLength_by_overLength(final String string) {
        final boolean isOverLength = StringUtils.isOverLength(string, string.length() - 1);

        assertThat(isOverLength).isTrue();
    }
}
