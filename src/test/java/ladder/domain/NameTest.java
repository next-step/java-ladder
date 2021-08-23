package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest
    @DisplayName("User 생성 성공 테스트")
    @ValueSource(strings = {"pobi", "hj", "seul", "hj2"})
    void User_생성_성공_테스트(String name) {
        Name user = new Name(name);
        assertThat(user).isEqualTo(new Name(name));
    }

    @ParameterizedTest
    @DisplayName("User 이름 길이 초과 생성 실패 테스트")
    @ValueSource(strings = {"hjjang", "eeseul"})
    void 이름_길이_초과_생성_실패_테스트(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(RuntimeException.class);
    }
}
