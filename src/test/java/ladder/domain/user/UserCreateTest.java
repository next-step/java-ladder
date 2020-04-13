package ladder.domain.user;
import static org.assertj.core.api.Assertions.*;

import ladder.domain.user.Users;
import org.junit.jupiter.api.Test;

public class UserCreateTest {

    @Test
    void maxNameLengthTest() {
        String names= "pobi,honux,crong11111,jk";
        assertThatThrownBy(() ->new Users(names)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void nameInputTest() {
        String names= "pobi,honux,crong,jk";
        Users user = new Users(names);
        assertThat(user.getLine().size()).isEqualTo(4);
        assertThat(user.getLine()).containsExactly("pobi","honux","crong","jk");
    }
}
