package step3.ladderGame.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @DisplayName("생성")
    @Test
    void create() {
        Users users = new Users("a,b,c,d,e");
        assertThat(users).isInstanceOf(Users.class);
    }

}
