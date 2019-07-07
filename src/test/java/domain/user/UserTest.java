package domain.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test(expected = IllegalArgumentException.class)
    public void name_length_validation() {
        //given
        String name = "123456";

        //when
        User user = new User(name);
    }

    @Test
    public void 이름_일치() {
        //given
        String name = "차슈덮밥";

        //when
        User user = new User(name);

        //then
        assertThat(user.match(name)).isTrue();
    }
}
