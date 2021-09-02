package ladder.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("user 이름을 받아 user를 생성할 수 있다.")
    void userCreateTest() {

        // given
        String input = "name";

        // when
        User user = new User(input);

        // then
        assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("Name 객체를 받아 user를 생성할 수 있다.")
    void userCreateByNameTest() {

        // given
        Name input = new Name("name");

        // when
        User result = new User(input);

        // then
        assertThat(result).isEqualTo(new User("name"));
    }

}