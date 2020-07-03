package nextstep.ladder.domain;

import nextstep.ladder.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @DisplayName("사용자 이름 목록 입력 시 이름 개수 만큼 User 목록 생성")
    @Test
    void createUsersTest() {
        // given
        String names = "a,b,c";

        // when
        Users users = new Users(names);

        // then
        assertThat(users.getUsers()).hasSize(StringParser.splits(names).size());
    }
}