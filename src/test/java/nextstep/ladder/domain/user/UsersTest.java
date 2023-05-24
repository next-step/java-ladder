package nextstep.ladder.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UsersTest {

    @Test
    void Users_생성테스트() {
        //given
        String input = "A,B,C,D,E";

        //when
        Users users = new Users(input);

        //then
        assertThat(users.userCount()).isEqualTo(5);
    }

    @Test
    public void Invalid_입력값() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Users(""));
    }
}
