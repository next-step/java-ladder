package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @DisplayName("Users 객체 생성 테스트")
    @Test
    void Users_객체생성() {
        String[] usersArr = {"user1", "user2", "user3"};
        Users users = Users.create(usersArr);

        Assertions.assertThat(users.size()).isEqualTo(usersArr.length);
    }

}
