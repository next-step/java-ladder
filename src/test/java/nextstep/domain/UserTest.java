package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    void 유저이름이_다섯글자_넘을경우() {
        assertThatThrownBy(() -> {
            new User("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}