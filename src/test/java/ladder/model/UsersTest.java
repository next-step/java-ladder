package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UsersTest {
    @Test
    void testSuccessWhenParse() {
        String[] input = {"pobi", "honux", "crong", "jk"};

        Users users = Users.from(input);

        assertThat(users.getUser(0).getName()).isEqualTo("pobi");
        assertThat(users.getUser(1).getName()).isEqualTo("honux");
        assertThat(users.getUser(2).getName()).isEqualTo("crong");
        assertThat(users.getUser(3).getName()).isEqualTo("jk");
    }

    @Test
    void testIndexOf() {
        String[] input = {"pobi", "honux", "crong", "jk"};

        Users users = Users.from(input);

        assertThat(users.indexOf(input[0])).isEqualTo(0);
        assertThat(users.indexOf(input[1])).isEqualTo(1);
        assertThat(users.indexOf(input[2])).isEqualTo(2);
        assertThat(users.indexOf(input[3])).isEqualTo(3);
    }

    @Test
    void testFailIndexOf() {
        String[] input = {"pobi"};

        Users users = Users.from(input);

        assertThatThrownBy(() -> users.indexOf("pobi2"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
