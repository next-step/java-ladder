package nextstep.ladder;

import nextstep.ladder.domain.user.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsersTest {

    @Test
    @DisplayName("유저 이름들 입력 시 Users 입력한 유저 참가")
    void INPUT_USER_NAMES_THEN_JOIN() {

        Assertions.assertThat(
            Users.join("pobi", "honux", "crong", "jk").numberOfUsers()
        ).isEqualTo(4);
    }

}
