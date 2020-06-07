package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("유저 생성 테스트")
    void create(){
        User user = new User("ray");
        assertThat(user).isEqualTo(new User("ray"));
    }
}
