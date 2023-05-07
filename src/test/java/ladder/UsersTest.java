package ladder;

import ladder.model.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    @DisplayName("참여자 이름으로 생성할 수 있다")
    @Test
    void create() {
        Users users = Users.of(List.of("user1", "user2"));
        assertThat(users.size()).isEqualTo(2);
    }
}
