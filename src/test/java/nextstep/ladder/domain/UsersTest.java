package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class UsersTest {

    static final String NAMES = "pobi,honux,crong,jk";

    @Test
    void createByString() {
        Users users = Users.createByString(NAMES);
        System.out.println(users);
        assertThat(users.getUsers().size()).isEqualTo(4);
    }
}