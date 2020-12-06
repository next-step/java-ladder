package ladder.domain;

import ladder.ladderexceptions.InvalidUserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("Getter")
    void testGetter() {
        assertThat(new User("ABC").getName())
                .isEqualTo("ABC");
    }

    @Test
    @DisplayName("출력을 위해 입력이 금지된 이름 all")
    void testDeniedName() {
        assertThatExceptionOfType(InvalidUserNameException.class).isThrownBy(
                () -> new User("all")
        );
    }
}
