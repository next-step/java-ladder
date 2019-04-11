package domain.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test(expected = IllegalArgumentException.class)
    public void name_length_validation() {
        String name = "123456";
        User user = new User(name);
    }

    @Test
    public void 이름_일치() {
        String name = "차슈덮밥";
        User user = new User(name);
        assertThat(user.match(name)).isTrue();
    }
}
