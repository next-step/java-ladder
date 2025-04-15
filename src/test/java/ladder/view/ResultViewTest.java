package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewTest {
    @DisplayName("유저 이름 출력 테스트")
    @Test
    void printUserNamesTest() {
        List<User> users = List.of(
                new User("pobi"),
                new User("honux"),
                new User("crong"),
                new User("jk")
        );

        ByteArrayOutputStream outString = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outString));

        ResultView.printUserNames(users);

        String expectedOutput = "pobi honux crong    jk\n";
        assertEquals(expectedOutput, outString.toString());

        System.setOut(System.out);
    }

    @DisplayName("사다리 출력 테스트")
    @Test
    void printLadderTest() {
        Ladder ladder = new Ladder(4, 5, List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(false, true, false),
                List.of(true, false, true)
        ));

        ByteArrayOutputStream outString = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outString));

        ResultView.printLadder(ladder);

        String expectedOutput = "    |-----|     |-----|\n" +
                "    |     |-----|     |\n" +
                "    |-----|     |     |\n" +
                "    |     |-----|     |\n" +
                "    |-----|     |-----|\n";
        assertEquals(expectedOutput, outString.toString());

        System.setOut(System.out);
    }
}
