package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void 참여자의_이름은_최대_5글자() {
        String name = "michael";

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User(name))
                .withMessage("참여자의 이름은 최대 5글자입니다");

    }
}
