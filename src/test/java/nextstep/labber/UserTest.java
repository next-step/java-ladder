package nextstep.labber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    void create() {
        assertThatThrownBy(() -> {
            new User("banana");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}