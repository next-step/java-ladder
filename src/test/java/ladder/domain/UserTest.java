package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {
    @DisplayName("참여자 이름이 5글자 초과일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef","abcdefg"})
    void 참여자_생성_이름_5글자_초과(String userName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> User.create(userName))
                .withMessageMatching("참여자 이름은 최대 5글자 입니다.");
    }

}
