package ladder;

import ladder.ladderexceptions.InvalidUsersNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class UsersTest {

    @Test
    @DisplayName("Users 생성 테스트(Null)")
    void testNullInstanceTest() {
        assertThatNullPointerException().isThrownBy(
                () -> new Users(null)
        );
    }

    @Test
    @DisplayName("Users 생성 테스트 빈 배열")
    void testEmptyInstance() {
        assertThatExceptionOfType(InvalidUsersNumberException.class).isThrownBy(
                () -> new Users(new ArrayList<>())
        );
    }

    @Test
    @DisplayName("최소 인원(2) 미만 시의 예외")
    void testWhenLessMember() {
        assertThatExceptionOfType(InvalidUsersNumberException.class).isThrownBy(
                () -> {
                    List<String> users = Arrays.asList("BSH");
                    new Users(users);
                }
        );
    }
}
