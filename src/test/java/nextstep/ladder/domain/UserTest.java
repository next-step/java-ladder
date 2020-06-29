package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void climb_right() {
        // given
        Line line = new Line(3, () -> true);
        User user = new User("a", 0);

        // when
        user.climb(line);

        // then
        assertThat(user.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    void climb_left() {
        // given
        Line line = new Line(3, () -> true);
        User user = new User("a", 1);

        // when
        user.climb(line);

        // then
        assertThat(user.getCurrentPosition()).isEqualTo(0);
    }
}