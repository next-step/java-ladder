package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    private List<User> users;

    @BeforeEach
    void setUp() {
        initUsers();
    }

    private List<User> initUsers() {
        users = new ArrayList<>();
        users.add(new User("pobi"));
        users.add(new User("tommy"));
        users.add(new User("honux"));
        users.add(new User("crong"));
        return users;
    }

    @Test
    void userSize() {
        assertThat(users).hasSize(4);
    }
}
