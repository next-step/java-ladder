package nextstep.ladder.domain;

import nextstep.ladder.factory.LadderFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author han
 */
class LadderTest {

    @Test
    void create() {
        Users users = Users.createByString(UsersTest.NAMES);
        Height height = new Height(5);
        assertDoesNotThrow(() -> Ladder.of(LadderFactory.createLines(users, height)));
    }
}