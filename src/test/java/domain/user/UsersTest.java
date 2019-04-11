package domain.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @Test
    public void name() {
        String names = "pobi,honux,crong,jk";
        Users users = new Users(names);
        assertThat(users.size()).isEqualTo(4);
    }
}
