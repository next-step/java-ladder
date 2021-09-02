package nextstep.ladder;

import nextstep.ladder.domain.UserName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserNameTest {

    @Test
    public void createTest(){
        UserName userName = new UserName("boss");
        assertThat(userName).isEqualTo(new UserName("boss"));
    }

    @Test
    @DisplayName("5글자 넘으면 에러가 나오는 지 테스트")
    public void length_error_test(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new UserName("arnold"));
    }
}
