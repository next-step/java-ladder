package ladder.domain;

import ladder.ladderexceptions.InvalidUsersNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        assertThatThrownBy(() -> new Users(new ArrayList<>()))
                .isInstanceOf(InvalidUsersNumberException.class)
                .hasMessage("최소 1인 이상의 사용자가 필요합니다.");
    }

    @Test
    @DisplayName("최소 인원(2) 미만 시의 예외")
    void testWhenLessMember() {
        assertThatThrownBy(
                () -> {
                    List<String> users = Arrays.asList("BSH");
                    new Users(users);
                }
        ).isInstanceOf(InvalidUsersNumberException.class)
                .hasMessage("최소 1인 이상의 사용자가 필요합니다.");
    }

    @Test
    @DisplayName("Size 확인")
    void testSize() {
        List<String> users = Arrays.asList("BSH", "ABC");

        assertThat(users.size()).isEqualTo(2);
    }
}
