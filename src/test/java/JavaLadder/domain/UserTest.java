package JavaLadder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {
    @Test
    public void userTest() {
        User user = new User("test");
        assertThat(user.getName()).isEqualTo("test");
    }

    @Test
    public void userSizeTest() {
        String name = "test123";
        assertThatThrownBy(() -> {new User (name);}).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[" + name + "]: 5자리 이하만 입력가능합니다.");
    }

    @Test
    public void userPointTest() {
        User user = new User("test", 0);
        assertThat(user.getPoint()).isEqualTo(new Point(0));
    }
}
