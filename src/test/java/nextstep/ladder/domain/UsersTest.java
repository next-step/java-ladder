package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    @Test
    void name() {
        assertThatThrownBy(() -> new Users("aa, aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 중복되었습니다.");
    }
}
