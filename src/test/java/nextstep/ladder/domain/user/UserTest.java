package nextstep.ladder.domain.user;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class UserTest {
    private String testName = "test";
    private String exceedLengthName = "a".repeat(100);

    @ParameterizedTest(name = "[{0}] 이름은 잘못된 이름으로 예외 발생")
    @NullAndEmptySource
    void userEmptyTest(String name) {
        Assertions.assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 유저명 입니다");
    }

    @Test
    @DisplayName("이름은 최대 5글자이며, 초과시 예외 발생")
    void exceedLengthTest() {
        Assertions.assertThatThrownBy(() -> new User(exceedLengthName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 유저명 입니다");
    }
}
