package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    @DisplayName("유저 생성 테스트")
    @Test
    void create_user() {
        assertThatNoException().isThrownBy(() -> new User("pobi"));
    }
}
