package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author han
 */
class UsersTest {

    @Test
    void createByString() {
        String input = "pobi,honux,crong,jk";
        Users users = Users.createByString(input);
        assertThat(users.getUsers().size()).isEqualTo(4);
    }
}