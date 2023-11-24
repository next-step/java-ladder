package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @Test
    public void getUser() {
        Users users = new Users();
        assertThat(users.getUser("crong")).isEqualTo(new User("crong", 35));
    }


    @Test
    public void getDefaultUser() {
        Users users = new Users();
        assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
    }
}
