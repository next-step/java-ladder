package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.exception.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UsersTest {

    @DisplayName("유저들에 여러명을 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_users_when_create_by_comma_separateValue(final String rawUsers) {
        // when
        final Users users = Users.ofSeparator(rawUsers);
        final int expectLength = rawUsers.split(Users.SEPARATOR).length;

        // then
        assertThat(users.size()).isEqualTo(expectLength);
    }

    @DisplayName("유저들에 1명을 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "d",
            "zzzdd",
            "김재연"
    })
    void should_return_users_when_create_by_single_username(final String singleUsername) {
        // when
        final Users users = Users.ofSeparator(singleUsername);

        // then
        assertThat(users).isNotNull();
    }

    @DisplayName("유저 이름으로 인덱스를 가져온다.")
    @Test
    void should_return_userIndex_when_findIndexByUsername() {
        // given
        final Users users = Users.ofSeparator("a,b,c,d,e");

        // when
        final int aIndex = users.findIndexByUsername(Username.valueOf("a"));
        final int eIndex = users.findIndexByUsername(Username.valueOf("e"));

        // then
        assertThat(aIndex).isEqualTo(0);
        assertThat(eIndex).isEqualTo(4);
    }

    @DisplayName("해당 이름이 없으면 에러를 발생한다.")
    @Test
    void should_throw_UserNotFoundException_when_notFoundIndexByUsername() {
        // given
        final Users users = Users.ofSeparator("a,b,c,d,e");

        // when / then
        assertThatExceptionOfType(UserNotFoundException.class)
                .isThrownBy(() -> {
                    users.findIndexByUsername(Username.valueOf("z"));
                });

    }
}
