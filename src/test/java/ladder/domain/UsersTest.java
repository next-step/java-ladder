package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UsersTest {

    @ParameterizedTest
    @CsvSource({"testA,1", "testB,2"})
    void shouldFindUserPositionByUsers(String username, int position) {
        User user = new User(username);
        Position userPosition = new Position(position);
        Users users = new Users();
        users.add(userPosition, user);

        assertThat(users.findUserPositionByUsers(List.of(user))).containsExactly(userPosition);
    }

    @Test
    void shouldNotFindUserByUsername_whenUsernameNotExist() {
        User user = new User("testA");
        Users users = new Users(user);

        assertThatThrownBy(() -> users.findUserPositionByUsers(List.of(new User("hello"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldFindAllUsers() {
        User userA = new User("testA");
        User userB = new User("testB");
        Users users = new Users(userA, userB);

        assertThat(users.findAllUser()).contains(userA, userB);
    }

    @ParameterizedTest
    @CsvSource({"testA,1", "testB,2"})
    void shouldFindUserByPosition(String username, int position) {
        User user = new User(username);
        Position userPosition = new Position(position);
        Users users = new Users();
        users.add(userPosition, user);

        assertThat(users.findUserByPosition(userPosition)).isEqualTo(user);
    }
}
