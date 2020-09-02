package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    private Users users;

    @BeforeEach
    void setUp() {
        List<User> userNames = User.generateUsers("pobi,tommy,honux,jk,crong");
        users = Users.from(userNames);
    }

    @Test
    void userSize() {
        assertThat(users.size()).isEqualTo(5);
    }
}
