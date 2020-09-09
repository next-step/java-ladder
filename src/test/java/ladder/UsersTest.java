package ladder;

import ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,honux,crong,jk")
    @DisplayName("참여자 인원 수가 맞는지")
    public void userCount(String users) {
        Users userList = new Users(users);
        assertThat(userList.getUserCount()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi")
    @DisplayName("참여자가 2명 이상인지")
    public void userCountMinimum(String user) {
        assertThatThrownBy(() -> new Users(user))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자는 2명 이상이어야 합니다.");
    }
}
