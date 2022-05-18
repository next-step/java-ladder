package ladder;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class UserGeneratorTest {
    @Test
    void 사다리게임_유저_이름은_쉼표로_구분한다() {
        List<User> users = UserGenerator.generate("pobi,honux");
        assertThat(users).contains(new User("pobi"), new User("honux"));
    }
}