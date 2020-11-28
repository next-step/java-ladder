package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    private List<User> users = Arrays.asList(new User("pobi")
            , new User("honux")
            , new User("crong")
            , new User("jk"));

    @Test
    void test_getUsernames() {
        // Given
        Users users = new Users(this.users);

        // When
        String userNames = users.getUserNames();

        System.out.println(userNames);
    }
}