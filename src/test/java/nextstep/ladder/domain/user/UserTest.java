package nextstep.ladder.domain.user;


import nextstep.ladder.error.exception.UserNameEmptyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class UserTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void User는_사용자의_이름이_null_이거나_빈_문자열일때_예외가_발생해야한다(String input) {
        assertThatThrownBy(() -> new User(input))
            .isInstanceOf(UserNameEmptyException.class)
            .hasMessage("UserName은 null이거나 빈 값일수 없습니다. 입력값: " + input);
    }

    @Test
    public void UserName의_최대_크기가_5를_넘을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new User("김남협남협김"))
            .isInstanceOf(UserNameSizeException.class)
            .hasMessage("UserName의 최대 크기는 5입니다. 입력값: 김남협남협김");
    }

    @ParameterizedTest
    @ValueSource(strings = {"혁", "우주", "김남협", "김남협남", "김남협남김"})
    public void UserName은_5자_크기까지_생성된다(String input) {
        User user = new User(input);
        assertThat(user.getUserName()).isEqualTo(input);
    }

}