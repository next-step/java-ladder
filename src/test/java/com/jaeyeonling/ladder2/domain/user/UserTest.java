package com.jaeyeonling.ladder2.domain.user;

import com.jaeyeonling.ladder2.exception.LongerThanMaxLengthUsernameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @DisplayName("유저 이름에 길이가 " + Username.MAX_LENGTH + " 를 넘는 값이 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void shouldLongerThanMaxLengthUsernameException(final String longerThanMaxLengthUsername) {
        Assertions.assertThatExceptionOfType(LongerThanMaxLengthUsernameException.class)
                .isThrownBy(() -> User.of(longerThanMaxLengthUsername));
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
        final User user = User.of(rawUsername);
        final User expect = User.of(rawUsername);

        // when
        final boolean equals = user.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(user == expect).isTrue();
    }

    @DisplayName("시각화 시 길이는 " + Username.MAX_LENGTH + " 이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg",
            "다섯글자다"
    })
    void visualizeLength(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);

        // when
        final String visualizedUser = user.visualize();

        // then
        assertThat(visualizedUser).hasSize(Username.MAX_LENGTH);
    }

    @DisplayName("시각화 후 trim 시 입력과 같은 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg",
            "다섯글자다"
    })
    void visualizeEquals(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);

        // when
        final String visualizedUsername = user.visualize().trim();

        // then
        assertThat(visualizedUsername).isEqualTo(rawUsername);
    }
}
