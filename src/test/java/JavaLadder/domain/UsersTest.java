package JavaLadder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UsersTest {
    @Test
    public void splitNameTest() {
        String input = "test1,test2,test3";
        Users users = new Users(input);
        assertThat(users.getName(0)).isEqualTo("test1");
    }

    @Test
    public void usersSizeTest() {
        String input = "test1,test2,test3";
        Users users = new Users(input);
        assertThat(users.size()).isEqualTo(3);
    }
}
