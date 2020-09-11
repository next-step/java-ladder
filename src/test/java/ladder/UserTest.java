package ladder;

import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("빈 값일 때 에러 발생 여부")
    public void userNameNull(String userName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new User(userName));
    }

    @ParameterizedTest
    @ValueSource(strings = "taehee")
    @DisplayName("이름이 5글자 이내인지 테스트")
    public void userLength(String userName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new User(userName));
    }
}
