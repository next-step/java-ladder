package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void 순서에_맞춰_위치를_초기화한다() {
        User user = new User("user1", 1);
        assertThat(user.getPosition()).isEqualTo(Point.valueOf(1, 1));
    }
}
