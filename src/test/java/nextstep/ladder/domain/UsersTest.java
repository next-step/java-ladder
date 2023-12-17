package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void 이름의_위치를_찾으면_찾을_수_있다() {
        Users users = new Users("a", "b", "c");
        assertThat(users.positionUserName("a")).isEqualTo(0);
    }
}