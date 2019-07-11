package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.exception.EmptyUsernameException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthUsernameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UsernameTest {

    @DisplayName("유저 이름에 빈 값이나 null 값이 들어가면 실패한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void throwEmptyUsernameException(final String rawUsername) {
        Assertions.assertThatExceptionOfType(EmptyUsernameException.class)
                .isThrownBy(() -> Username.valueOf(rawUsername));
    }

    @DisplayName("유저 이름에 길이가 " + Username.MAX_LENGTH + " 를 넘는 값이 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void throwLongerThanMaxLengthUsernameException(final String longerThanMaxLengthUsername) {
        Assertions.assertThatExceptionOfType(LongerThanMaxLengthUsernameException.class)
                .isThrownBy(() -> Username.valueOf(longerThanMaxLengthUsername));
    }

    @DisplayName("유저 이름이 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg"
    })
    void equals(final String rawUsername) {
        // given
        final Username username = Username.valueOf(rawUsername);
        final Username expect = Username.valueOf(rawUsername);

        // when
        final boolean equals = username.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(username == expect).isTrue();
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
    void equalsVisualize(final String rawUsername) {
        // given
        final Username username = Username.valueOf(rawUsername);

        // when
        final String visualizeUsername = username.visualize();

        // then
        assertThat(visualizeUsername).isEqualTo(rawUsername);
    }
}