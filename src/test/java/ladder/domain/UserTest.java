package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    void shouldValidateUsername_lengthCond() {
        assertThatThrownBy(() -> new User("hellow")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldValidateUsername_nullEmptyCond() {
        assertThatThrownBy(() -> new User(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User("   ")).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void shouldReturnMaxLength() {
        User username = new User("test");
        String result = "당첨!!!!!!!!!!!!!!!!";

        assertThat(username.maxLength(result)).isEqualTo(result.length());
    }

}
