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
    void shouldFindUserPositionByUsernames(String username, int position) {
        User user = new User(username);
        Position userPosition = new Position(position);
        Users users = new Users();
        users.add(userPosition, user);

        assertThat(users.findUserPositionByUsernames(List.of(new UserName(username)))).containsExactly(userPosition);
    }

    @Test
    void shouldNotFindUserByUsername_whenUsernameNotExist() {
        User user = new User("testA");
        Users users = new Users(user);

        assertThatThrownBy(() -> users.findUserPositionByUsernames(List.of(new UserName("hello"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"testA,testB"})
    void shouldFindAllUsers(String usernameA, String usernameB) {
        User userA = new User(usernameA);
        User userB = new User(usernameB);
        Users users = new Users(userA, userB);

        assertThat(users.findAllUsernames()).contains(new UserName(usernameA), new UserName(usernameB));
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
