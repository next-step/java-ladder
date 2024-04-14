package nextstep.ladder;

import nextstep.ladder.domain.user.UserName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNameTest {

    @Test
    @DisplayName("입력된 이름이 5자 초과 시 IllegalArgumentException")
    void INPUT_LONGER_THAN_FIVE_THAN_ILLEGAL_ARGUMENT_EXCEPTION() {
        Assertions.assertThatThrownBy(
            () -> UserName.of("IronMan")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 null 입력 시 NullException")
    void INPUT_NULL_THAN_NULL_POINTER_EXCEPTION() {
        Assertions.assertThatThrownBy(
            () -> UserName.of(null)
        ).isInstanceOf(NullPointerException.class);
    }
}
