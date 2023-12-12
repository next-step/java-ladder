package nextstep.ladder;

import nextstep.ladder.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    void 유저는_이름을_5_자를_초과할_수_없다() {
        assertThatThrownBy(() -> new User("banana")).isInstanceOf(IllegalArgumentException.class);
    }
}