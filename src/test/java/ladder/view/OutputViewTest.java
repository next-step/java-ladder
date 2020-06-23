package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OutputViewTest {

    @DisplayName("user들이 print 된다.")
    @Test
    public void printUsersTest() {
        List<User> users = User.of(List.of("pobi","honux","crong","jk"));
        OutputView.printUsers(users);
    }

    @DisplayName("Ladder가 print 된다")
    @Test
    public void printLadderTest() {
        Ladder ladder = new Ladder(5, 4);
        OutputView.printLadder(ladder);
    }
}