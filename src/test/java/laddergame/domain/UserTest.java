package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    @DisplayName("유저 생성 테스트")
    @Test
    void create_user() {
        assertThat(new User("pobi").getName().trim()).isEqualTo("pobi");
        assertThatIllegalArgumentException().isThrownBy(() -> new User("pobiac"));
    }
}
