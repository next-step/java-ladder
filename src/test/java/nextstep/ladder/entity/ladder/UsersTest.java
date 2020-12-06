package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    private List<String> usersInput = Arrays.asList("pobi", "honux", "crong", "jk");

    @Test
    void test_getUsernames() {
        // Given
        Users users = new Users(usersInput);

        // When
        List<String> userNames = users.getUserNames();

        assertArrayEquals(userNames.toArray(), usersInput.toArray());
    }

    @Test
    void test_unmodifiableList() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Users users = new Users(usersInput);
            List<String> userNames = users.getUserNames();
            userNames.add("test");
        });
    }

    @Test
    void test_getPosition_success() {
        // Given
        Users users = new Users(usersInput);
        User user = new User(usersInput.get(1));

        // When
        int position = users.getPosition(user);

        // Then
        assertEquals(position, 2);
    }

    @Test
    void test_getPosition_fail() {
        // Given
        Users users = new Users(usersInput);
        User user = new User("unkn");

        // When
        int position = users.getPosition(user);

        // Then
        assertEquals(position, -1);
    }


}