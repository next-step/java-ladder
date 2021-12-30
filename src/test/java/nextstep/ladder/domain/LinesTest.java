package nextstep.ladder.domain;

import nextstep.ladder.factory.LadderFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class LinesTest {

    @Test
    void create() {
        Height height = new Height(5);
        Users users = Users.createByString(UsersTest.NAMES);
        assertThat(LadderFactory.createLines(users.width(), height).getLinesSize()).isEqualTo(5);
    }
}