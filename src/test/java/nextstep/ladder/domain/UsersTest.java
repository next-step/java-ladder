package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @Test
    @DisplayName("참가자 리스트 생성 기능")
    void initUsers() {
        String names = "java,study,game";
        Users users = setUp(names);

        assertThat(users.getUsers().size()).isEqualTo(3);
    }

    private Users setUp(String names) {
        InputUsers inputUsers = InputUsers.createInputUsers(names);
        return Users.createUsers(inputUsers);
    }

}