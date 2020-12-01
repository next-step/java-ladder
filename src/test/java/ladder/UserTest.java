package ladder;

import ladder.ladderexceptions.InvalidUserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class UserTest {

    @Test
    @DisplayName("Null 값 테스트")
    void testNullValue() {
        assertThatNullPointerException().isThrownBy(
                () -> new User(null)
        );
    }

    @Test
    @DisplayName("Empty String Test")
    void testEmptyString() {
        assertThatExceptionOfType(InvalidUserNameException.class).isThrownBy(
                () -> new User("")
        );
    }

    @Test
    @DisplayName("5자 초과 이름")
    void testLongName() {
        assertThatExceptionOfType(InvalidUserNameException.class).isThrownBy(
                () -> new User("SIXsix")
        );
    }
}
