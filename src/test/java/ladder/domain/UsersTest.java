package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    @Test
    @DisplayName("Users 생성자 테스트")
    void constructor() {
        assertThat(new Users(Arrays.asList(new User("aaa"), new User("bbb"))))
                .isEqualTo(new Users(Arrays.asList(new User("aaa"), new User("bbb"))));
    }
}
