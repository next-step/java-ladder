package ladder;
import static org.assertj.core.api.Assertions.*;

import ladder.user.Users;
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
        assertThat(user.users().size()).isEqualTo(4);
        assertThat(user.users()).containsExactly("pobi","honux","crong","jk");
    }
}
