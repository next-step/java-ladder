package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    Users users;

    @Test
    @DisplayName("참가자 리스트 생성 기능")
    void initUsers() {
        String names = "java,study,game";
        InputUsers inputUsers = new InputUsers(names);
        users = Users.createUsers(inputUsers);

        assertThat(users.getUsers().size()).isEqualTo(3);
    }

}