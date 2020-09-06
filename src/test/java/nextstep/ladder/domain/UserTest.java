package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    @ParameterizedTest
    @CsvSource(value = {"test,6"}, delimiter = ',')
    @DisplayName("정상적인 사용자의 생성 테스트")
    void normalUserTest(String userName) {
        User user = User.newInstance(userName,0);
        assertThat(user).isEqualTo(User.newInstance(userName,0));
    }

    @Test
    @DisplayName("사용자 이름이 5초과시 에러 테스트")
    void overUserNameLengthTest() {
        assertThatThrownBy(() -> {
            User.newInstance("CleanCode",0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
