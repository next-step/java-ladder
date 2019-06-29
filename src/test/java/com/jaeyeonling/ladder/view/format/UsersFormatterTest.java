package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersFormatterTest extends FormatterSupport {

    @DisplayName("유저들 포매터 생성에 성공한다.")
    @Test
    void create() {
        // then
        assertThat(usersFormatter).isNotNull();
    }

    @DisplayName("이름이 5글자인 유저들에 포맷팅에 성공한다.")
    @Test
    void Format__Username5Length_ExpectFormat() {
        // given
        final String rawUsers = "ㅁㅁㅁㅁ,ㅇㅇㅇㅇㅇ,아아아아아";
        final Users users = Users.of(rawUsers);

        // when
        final String formatted = usersFormatter.format(users);
        final String expect = "ㅁㅁㅁㅁ ㅇㅇㅇㅇㅇ 아아아아아";

        // then
        assertThat(formatted).isEqualTo(expect);
    }
}
