package ladder.domain.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import ladder.domain.Position;
import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;

class UsersTest {

    @Test
    void 객체생성_실패_테스트() {
        User user1 = User.of("test", new Position(0));
        User user2 = User.of("test", new Position(1));
        assertThrows(LadderGameException.class, () -> Users.from(Arrays.asList(user1, user2)));
    }
}