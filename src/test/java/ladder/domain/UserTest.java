package ladder.domain;

import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @DisplayName("이름을 가져올 수 있다.")
    @Test
    public void getNameTest() {
        String name = "test";

        assertThat(User.of(name).getName()).isEqualTo(name);
    }

    @DisplayName("입력받는 이름이 5글자를 초과하면 IllegalArgumetException 아 발생한다.")
    @Test
    public void createUserOverFiveLengthTest() {
        String name = "test1234";

        assertThatThrownBy(() -> {
            User.of(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받는 이름이 5글자를 이하면 정상적으로 생성된다,")
    @Test
    public void crateUserTest() {
        String name = "test";
        String name1 = "test1";
        String name2 = "test2";

        assertThat(User.of(name)).isNotNull();
        assertThat(User.of(List.of(name, name1, name2))).containsOnly(User.of(name), User.of(name1), User.of(name2));
    }

}
