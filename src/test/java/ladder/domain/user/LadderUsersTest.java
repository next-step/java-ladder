package ladder.domain.user;

import ladder.domain.user.LadderUsers;
import ladder.domain.user.Username;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderUsersTest {

    @Test
    @DisplayName("사용자 이름목록을 정상적으로 생성하는지 확인한다")
    void checkUserName() {
        LadderUsers ladderUsers = LadderUsers.of(Arrays.asList("john", "bob", "jinho", "foo", "bar"));
        assertThat(ladderUsers.getUsernames().size()).isEqualTo(5);
        assertThat(ladderUsers.getUsernames().get(0)).isEqualTo(Username.of("john"));
    }

    @Test
    @DisplayName("사용자 이름이 5글자 이상인경우 예외처리를 확인한다")
    void checkUserName2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LadderUsers.of(Arrays.asList("john", "bob", "jinho", "foo", "ronaldo"));
                }).withMessageMatching("Username length is over 5");
    }
}
