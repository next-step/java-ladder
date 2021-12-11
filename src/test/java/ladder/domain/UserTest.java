package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    @DisplayName("User 생성자 테스트")
    void constructor() {
        assertThat(new User("test")).isEqualTo(new User("test"));
    }
}
