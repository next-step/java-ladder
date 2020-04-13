package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLine;
import ladder.domain.user.Users;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void createLadderWithUsers() {
        Users users = new Users("peter,jone,harim,amy");
        int height = 5;
        Ladder ladder = Ladder.of(height, users);
        assertThat(ladder.getLadder().get(0).getLine()).isEqualTo(users.getLine());
    }

    @Test
    void createLadderTest() {
        Users users = new Users("peter,jone,harim,amy");
        int height = 5;
        Ladder ladder = Ladder.of(height, users.countOfUser());
        assertThat(ladder.getLadder().size()).isEqualTo(5);
        assertThat(ladder.getLadder().get(0).getLine().size()).isEqualTo(users.countOfUser());

    }

    @Test
    void createLadderLineTest() {
        int person = 5;
        Line line = new LadderLine(person);
        line.getLine().stream().forEach((l) -> System.out.print(l));
    }
}
