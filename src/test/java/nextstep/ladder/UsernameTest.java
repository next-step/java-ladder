package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsernameTest {

    @Test
    void 사용자_이름_길이_exception(){
        assertThatThrownBy(() -> {
                Username username = new Username("abcdef");
            })
            .isInstanceOf(IllegalArgumentException.class);
    }
}
