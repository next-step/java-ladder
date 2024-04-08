package nextstep.ladder;

import nextstep.ladder.domain.UserName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"danden, asdfegee"})
    @DisplayName("5글자 초과시 에러 발생")
    void testInvalidLengthName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(name));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈 문자열일 경우 에러 발생")
    void testEmptyName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "pobi", "yong", "A"})
    @DisplayName("유저 이름 생성 테스트")
    void testValidUserName(String name) {
        assertThat(new UserName(name).getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"all", "ALL"})
    @DisplayName("유저 이름이 all인 경우 에러 발생")
    void testInvalidUserName(String invalidName) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(invalidName));
    }


}
