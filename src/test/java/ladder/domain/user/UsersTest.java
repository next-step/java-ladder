package ladder.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    void usersNameTest() {
        String[] names  = "peter,jone,ethan,james".split(",");
        for (int i = 0; i < users.countOfUser(); i++) {
            assertThat(users.showUsers().get(i).userName()).isEqualTo(names[i]);
        }

    }

    @Test
    void c() {
        String names= "pobi,honux,crong,jk";
        Users user = new Users(names);
//        assertThat(user.showLine().size()).isEqualTo(4);
//        assertThat(user.showLine()).containsExactly("pobi","honux","crong","jk");
    }
}
