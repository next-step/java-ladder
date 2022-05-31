package ladder.domain;

import ladder.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LadderGameTest {

    @Test
    void 사다리를_출력할_때_유저의_이름도_같이_출력한다() {
        LadderGame ladderGameTest = new LadderGame(Arrays.asList(new User("pobi"), new User("honux"), new User("crong"), new User("jk")));
        List<String> names = ladderGameTest.drawUserList();

        Assertions.assertThat(names.contains("pobi")).isTrue();
        Assertions.assertThat(names.contains("honux")).isTrue();
    }

    @Test
    void test() {
        List<User> users = Arrays.asList(new User("pobi", 0), new User("honux", 1), new User("crong", 2), new User("jk", 3));
        LadderGame ladderGame = new LadderGame(users);
        List<Line> lines = ladderGame.getLines();
        ResultView.printLadder(ladderGame.drawUserList(), lines);

        for (User user : users) {
            for (Line line : lines) {
                user.move(line);
            }
        }

        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}
