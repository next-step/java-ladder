package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("유저의 이름은 5자리가 넘을 경우 예외를 발생시킨다")
    @Test
    void validateUserName() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new User("crystal");
        });

    }
}
