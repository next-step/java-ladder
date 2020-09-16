package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {

    @Test
    @DisplayName("user 생성 테스트")
    public void createUserTest(){
        User user = User.of("test");

        assertThat(user.toString()).isEqualTo("test");
    }

    @Test
    @DisplayName("user name 길이 초과 테스트")
    public void exceedUserNametest(){
        assertThatIllegalArgumentException().isThrownBy(()-> User.of("abcdef"))
                .withMessage("exceeded max user name length");

    }
}