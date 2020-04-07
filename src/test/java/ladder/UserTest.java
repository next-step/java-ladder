package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    @Test
    @DisplayName("사람의 이름은 최대 5글자까지 부여할 수 있다")
    void invalidUserWhenUserNameLengthLongerThanFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new User("wrongusername"));
    }
}
