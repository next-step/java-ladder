package nextstep.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("유저 이름은 5자가 넘을 수 없다.")
    void nameLength() {
        assertThrows(IllegalArgumentException.class, () -> new User("jymai-kim"));
    }

    @Test
    void name() {
        User user = new User("jyami");
        assertThat(user.getName()).isEqualTo("jyami");
    }
}