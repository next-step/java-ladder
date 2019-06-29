package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersFormatterTest extends FormatterSupport {

    @DisplayName("유저들 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(usersFormatter).isNotNull();
    }

    @DisplayName("이름이 5글자인 유저들에 포맷팅에 성공한다.")
    @Test
    void should_equals_5_lengthUsername_and_expectFormatUsername() {
        // given
        final String rawUsers = "ㅁㅁㅁㅁ,ㅇㅇㅇㅇㅇ,아아아아아";
        final Users users = Users.ofSeparator(rawUsers);

        // when
        final String formatted = usersFormatter.format(users);
        final String expect = "  ㅁㅁㅁㅁ ㅇㅇㅇㅇㅇ 아아아아아";

        // then
        assertThat(formatted).isEqualTo(expect);
    }

    @DisplayName("이름이 1글자인 유저들에 포맷팅에 성공한다.")
    @Test
    void should_equals_1_lengthUsername_and_expectFormatUsername() {
        // given
        final String rawUsers = "ㅁ,ㅇ,아";
        final Users users = Users.ofSeparator(rawUsers);

        // when
        final String formatted = usersFormatter.format(users);
        final String expect = "     ㅁ     ㅇ     아";

        // then
        assertThat(formatted).isEqualTo(expect);
    }
}
