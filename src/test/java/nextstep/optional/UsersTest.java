package nextstep.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @Test
    public void getUser() {
        Users users = new Users();
        Optional<User> optionalUser = users.getUser("crong");
        assertThat(optionalUser.isPresent()).isTrue();
        assertThat(optionalUser.get()).isEqualTo(new User("crong", 35));
    }


    @Test
    public void getDefaultUser() {
        Users users = new Users();
        Optional<User> optionalUser = users.getUser("codesquard");
        assertThat(optionalUser.isPresent()).isTrue();
        assertThat(optionalUser.get()).isEqualTo(Users.DEFAULT_USER);
    }
}
