package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UsersTest {

    @Test
    void shouldFindUserStartPositionByUsername() {
        User userA = userWithName("testA");
        User userB = userWithName("testB");
        Users users = new Users(List.of(userA, userB));

        assertThat(users.findUserByUsername(new UserName("testA"))).isEqualTo(userA);
        assertThat(users.findUserByUsername(new UserName("testB"))).isEqualTo(userB);
    }

    @Test
    void shouldNotFindUserByUsername_whenUsernameNotExist() {
        User userA = userWithName("testA");
        User userB = userWithName("testB");
        Users users = new Users(List.of(userA, userB));

        assertThatThrownBy(() -> users.findUserByUsername(new UserName("hello"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldFindAllUserByUsername(){
        User userA = userWithName("testA");
        User userB = userWithName("testB");
        Users users = new Users(List.of(userA, userB));

        List<User> foundUsers = users.findUserByUsernames(List.of(new UserName("testA"), new UserName("testB")));

        assertThat(foundUsers).containsExactly(userA,userB);
    }

    @Test
    void shouldGetAllUsername(){
        User userA = userWithName("testA");
        User userB = userWithName("testB");
        Users users = new Users(List.of(userA, userB));

        List<UserName> foundNames = users.findAllUserName();

        assertThat(foundNames).containsExactly(new UserName("testA"),new UserName("testB"));
    }


    private User userWithName(String name) {
        return User.withNameAndPosition(new UserName(name), new HorizontalPosition(0));
    }


}
