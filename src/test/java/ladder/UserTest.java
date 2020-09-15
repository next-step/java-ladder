package ladder;

import ladder.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    private User user;

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("빈 값일 때 에러 발생 여부")
    public void userNameNull(String userName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new User(userName, 0));
    }

    @ParameterizedTest
    @ValueSource(strings = "taehee")
    @DisplayName("이름이 5글자 이내인지 테스트")
    public void userLength(String userName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new User(userName, 0));
    }

    @BeforeEach
    void setupUser() {
        user = new User("pobi", 0);
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi")
    @DisplayName("사용자 명을 제대로 가져오는지")
    public void getUserName(String userName) {
        assertThat(user.getUserName()).isEqualTo(userName);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @DisplayName("사용자 위치를 제대로 가져오는지")
    public void getUserPosition(int userPosition) {
        assertThat(user.getPosition()).isEqualTo(userPosition);
    }
}
