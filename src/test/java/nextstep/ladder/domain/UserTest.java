package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final String NAME_FIXED_SIX_SPACE = "      ";

    @ParameterizedTest
    @CsvSource(value = {"test,6"}, delimiter = ',')
    @DisplayName("정상적인 사용자의 생성 테스트")
    void normalUserTest(String userName, int userNameLength) {
        StringBuilder fixedLengthUserName = new StringBuilder();
        String newPrefix = NAME_FIXED_SIX_SPACE.substring(userName.length());
        fixedLengthUserName.append(userName).append(newPrefix);

        User user = User.join(userName);

        assertThat(user.getFixedLengthUserName()).isEqualTo(fixedLengthUserName.toString());
        assertThat(user.getFixedLengthUserName().length()).isEqualTo(userNameLength);
    }

    @Test
    @DisplayName("사용자 이름이 5초과시 에러 테스트")
    void overUserNameLengthTest() {
        assertThatThrownBy(() -> {
            User.join("CleanCode");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
