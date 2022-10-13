package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UsersTest {

    @Test
    void shouldFindUserStartPositionByUsername(){
        User userA = userWithName("testA");
        User userB = userWithName("testB");
        Users users = new Users(List.of(userA,userB));

        assertThat(users.findStartPositionByUsername(new UserName("testA"))).isEqualTo(List.of(0));
        assertThat(users.findStartPositionByUsername(new UserName("testB"))).isEqualTo(List.of(1));
    }

    @Test
    void shouldNotFindUserByUsername_whenUsernameNotExist(){
        User userA = userWithName("testA");
        User userB = userWithName("testB");
        Users users = new Users(List.of(userA,userB));

        assertThatThrownBy(()->users.findStartPositionByUsername(new UserName("hello"))).isInstanceOf(IllegalArgumentException.class);
    }

    private User userWithName(String name) {
        return new User(new UserName(name));
    }


}
