package ladder.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    private Users users;

    @BeforeEach
    void setup(){
        String names = "peter,jone,ethan,james";
        users = new Users(names);
    }

    @Test
    void createUsersTest() {
        assertThat(users.showUsers().size()).isEqualTo(4);
    }

    @Test
    void findUserPosition() {
        String name ="peter";
        assertThat(users.findUserPosition(name)).isEqualTo(0);
        assertThat(users.findUserPosition("ethan")).isEqualTo(2);
        assertThatThrownBy(() ->users.findUserPosition("12")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void usersNameTest() {
        String[] names  = "peter,jone,ethan,james".split(",");
        for (int i = 0; i < users.countOfUser(); i++) {
            assertThat(users.showUsers().get(i).userName()).isEqualTo(names[i]);
        }
    }
}
