package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNameTest {

    @Test
    void shouldValidateUsername_lengthCond() {
        assertThatThrownBy(() -> new UserName("hellow")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldValidateUsername_nullEmptyCond() {
        assertThatThrownBy(() -> new UserName(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserName("   ")).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void shouldReturnMaxLength() {
        UserName username = new UserName("test");
        String result = "당첨!!!!!!!!!!!!!!!!";

        assertThat(username.maxLength(result)).isEqualTo(result.length());
    }

}
