package com.ladder.model;

import com.ladder.exception.UserNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserNameTest {

    @DisplayName("유저 이름을 생성하는데 성공한다")
    @Test
    void createUsername_success() {
        // given
        String name = "abcde";
        // when
        UserName result = UserName.of(name);
        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(UserName.of(name));
    }

    @DisplayName("유저 이름이 5자리 초과할 시 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void createUsername_whenLengthMoreThanFive_exception(String wrongName) {
        assertThatExceptionOfType(UserNameLengthException.class)
                .isThrownBy(() -> UserName.of(wrongName));
    }

    @DisplayName("유저 이름 빈 문자열 또는 null일 시 exception")
    @ParameterizedTest
    @NullAndEmptySource
    void createUsername_whenInputEmptyOrNull_exception(String nullName) {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> UserName.of(nullName));
    }
}