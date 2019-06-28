package com.jaeyeonling.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("isNullOrEmpty에 null 이나 빈 값을 입력 시 성공한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty_nullOrEmptyValue_returnTrue(final String nullOrEmptyValue) {
        // when
        final boolean isNullOrEmpty = StringUtils.isNullOrEmpty(nullOrEmptyValue);

        // then
        assertThat(isNullOrEmpty).isTrue();
    }


}
