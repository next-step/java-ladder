package nextstep.ladder.domain.user;


import nextstep.ladder.error.exception.UserNameEmptyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class UserTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void User는_사용자의_이름이_null_이거나_빈_문자열일때_예외가_발생해야한다(String input){
        Assertions.assertThatThrownBy(() -> new User(input))
            .isInstanceOf(UserNameEmptyException.class)
            .hasMessage("UserName은 null이거나 빈 값일수 없습니다. 입력값: " + input);
    }

}
