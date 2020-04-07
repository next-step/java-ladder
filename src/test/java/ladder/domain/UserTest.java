package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    void equalsUserName() {
        String userName = "pobi";
        User user = new User(userName, "200억");

        boolean actual = user.equalsUserName(userName);

        assertThat(actual).isTrue();
    }
}
