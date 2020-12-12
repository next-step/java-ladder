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
    @DisplayName("허용되지 않은 타입의 Casting Test")
    void testInvalidTypeCastingTest() {
        assertThatThrownBy(
                () -> new Users(Arrays.asList(1, 2, 3))
        ).isInstanceOf(ClassCastException.class);
    }

    @Test
    @DisplayName("List<User>와 List<String>의 동일성 테스트")
    void testEqualityOnOtherType() {
        List<String> input = Arrays.asList("a", "b", "c");
        List<User> expected = Arrays.asList(new User("a"), new User("b"), new User("c"));

        assertThat(new Users(input)).isEqualTo(new Users(expected));
    }

    @Test
    @DisplayName("Size 확인")
    void testSize() {
        List<String> users = Arrays.asList("BSH", "ABC");

        assertThat(users.size()).isEqualTo(2);
    }
}
