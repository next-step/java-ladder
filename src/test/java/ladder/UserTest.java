package ladder;

import ladder.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void 유저_이름은_Null이면_안된() {
        Assertions.assertThatThrownBy(() -> {
            User user = new User(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 유저_이름은_빈값이면_안된() {
        Assertions.assertThatThrownBy(() -> {
            User user = new User("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저의_이름은_최대5자_이다() {
        Assertions.assertThatThrownBy(() -> {
            User user = new User("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
