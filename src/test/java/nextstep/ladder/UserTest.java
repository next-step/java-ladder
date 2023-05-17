package nextstep.ladder;

import nextstep.ladder.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class UserTest {
    @Test
    void 이름_길이_테스트() {
        User user = new User("12345");
        assertThatIllegalArgumentException().isThrownBy(() ->
                user.validateNameLength("123456")
        ).withMessage("참가자 이름은 1자이상 5자 이하");
    }
}
