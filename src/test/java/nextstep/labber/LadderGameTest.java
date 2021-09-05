package nextstep.labber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void createLadder() {
        List<User> userList = Arrays.asList(new User("apple"), new User("mongo"), new User("hooju"));
        List<Line> ladder = new LadderGame(userList, 5).createLadder();

        assertThat(ladder.size()).isEqualTo(5);;
    }
}