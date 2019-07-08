package ladder.domain.model;

import ladder.domain.model.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UsersTest {

    @Test
    @DisplayName("사용자 이름목록을 정상적으로 생성하는지 확인한다")
    void checkUserName() {
        Users users = Users.of(Arrays.asList("john", "bob", "jinho", "foo", "bar"));
        assertThat(users.getUserNames().size()).isEqualTo(5);
        assertThat(users.getUserNames().get(0)).isEqualTo("john");
    }

    @Test
    @DisplayName("사용자 이름이 5글자 이상인경우 예외처리를 확인한다")
    void checkUserName2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Users.of(Arrays.asList("john", "bob", "jinho", "foo", "ronaldo"));
                }).withMessageMatching("Username length is over 5");
    }
}
