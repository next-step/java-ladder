package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @DisplayName("사용자 이름 목록 입력 시 이름 개수 만큼 User 목록 생성")
    @Test
    void createUsersTest() {
        // given
        List<String> names = Arrays.asList("a", "b", "c");

        // when
        Users users = new Users(names);

        // then
        assertThat(users.getUsers()).hasSize(names.size());
    }
}