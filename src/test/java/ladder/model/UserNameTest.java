package ladder.model;

import ladder.model.UserName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserNameTest {

    @Test
    void shouldValidateUsername_lengthCond(){
        Assertions.assertThatThrownBy(()->new UserName("hellow")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldValidateUsername_nullEmptyCond(){
        Assertions.assertThatThrownBy(()->new UserName(null)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->new UserName("   ")).isInstanceOf(IllegalArgumentException.class);
    }

}
