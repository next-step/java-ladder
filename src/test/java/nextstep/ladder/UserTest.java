package nextstep.ladder;

import nextstep.ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserTest {

    @Test
    @DisplayName("5글자 넘으면 에러가 나오는 지 테스트")
    public void length_error_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new User("arnold", 0));
    }
}
