package nextstep.ladder.factory;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author han
 */
class LadderFactoryTest {


    @Test
    void create() {
        Users users = Users.createByString("1,2,3,4,5");
        Height height = new Height(5);
        assertDoesNotThrow(() -> LadderFactory.from(users.width(), height));
    }
}