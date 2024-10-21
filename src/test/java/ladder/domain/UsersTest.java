package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class UsersTest {
    @Test
    void 사용자들_생성() {
        Users users = new Users(List.of(new UserName("hwan2"), new UserName("hwan3"), new UserName("hwan4")));
        assertThat(users).isNotNull();
    }

    @Test
    void 사용자들_중복검증() {
        assertThatThrownBy(() -> new Users(List.of(new UserName("hwan2"), new UserName("hwan2"), new UserName("hwan4"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}