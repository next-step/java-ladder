package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNameTest {
    @Test
    @DisplayName("UserName 생성자 테스트")
    void constructor() {
        assertThat(new UserName("aaa")).isEqualTo(new UserName("aaa"));
    }
}
