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

    @DisplayName("isNullOrEmpty에 문자열 값을 입력 시 false를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "asda", "sdfsdf", "asfsdfsd", "e23r32f", "dsvsdfsdsds",
            "sdvsdvsds", "dvsdwwe", "a", "23gr3eggre23erthge3r4er"
    })
    void should_return_false_when_isNullOrEmpty_by_notEmptyValue(final String notEmptyValue) {
        // when
        final boolean isNullOrEmpty = StringUtils.isNullOrEmpty(notEmptyValue);

        // then
        assertThat(isNullOrEmpty).isFalse();
    }
}
