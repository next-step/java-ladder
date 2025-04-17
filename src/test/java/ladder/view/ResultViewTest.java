package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.service.PointGenerator;
import ladder.service.StaticPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static ladder.support.TestConstants.POINTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewTest {
    @DisplayName("유저 이름 출력 테스트")
    @Test
    void printUserNamesTest() {
        List<User> userList = List.of(
                new User("pobi"),
                new User("honux"),
                new User("crong"),
                new User("jk")
        );
        Users users = new Users(userList);

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
        int countOfPerson = 4;
        LadderHeight height = new LadderHeight(5);
        PointGenerator pointGenerator = new StaticPointGenerator(POINTS);
        Ladder ladder = new Ladder(countOfPerson, height, pointGenerator);

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
