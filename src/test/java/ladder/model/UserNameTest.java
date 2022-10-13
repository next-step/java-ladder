package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

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
    void shouldReturnIsAllOrNot(){
        assertThat(new UserName(UserName.ALL_USER_NAME).isAllUser()).isTrue();
        assertThat(new UserName("test").isAllUser()).isFalse();
    }

    @Test
    void shouldReturnMaxLength(){
        UserName username = new UserName("test");
        String result = "당첨!!!!!!!!!!!!!!!!";

        assertThat(username.maxLength(result)).isEqualTo(result.length());
    }

}
