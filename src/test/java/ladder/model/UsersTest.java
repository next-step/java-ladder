package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
