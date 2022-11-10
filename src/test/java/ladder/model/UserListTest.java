package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserListTest {
    @Test
    void testSuccessWhenParse() {
        String input = "pobi,honux,crong,jk";

        UserList userList = UserList.parse(input);

        assertThat(userList.getUser(0).getName()).isEqualTo("pobi");
        assertThat(userList.getUser(1).getName()).isEqualTo("honux");
        assertThat(userList.getUser(2).getName()).isEqualTo("crong");
        assertThat(userList.getUser(3).getName()).isEqualTo("jk");
    }
}
