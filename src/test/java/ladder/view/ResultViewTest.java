package ladder.view;

import ladder.domain.*;
import ladder.service.PointGenerator;
import ladder.service.StaticPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static ladder.support.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewTest {
    @DisplayName("유저 이름 출력 테스트")
    @Test
    void printUserNamesTest() {
        Users users = new Users(USERS);

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
        Users users = new Users(USERS);
        LadderHeight height = new LadderHeight(5);
        Results results = new Results(RESULTS);
        PointGenerator pointGenerator = new StaticPointGenerator(POINTS);
        Ladder ladder = new Ladder(users, results, height, pointGenerator);

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

    @DisplayName("결과 한개 출력 테스트")
    @Test
    void printFindResultTest() {
        Result result = new Result("꽝");

        ByteArrayOutputStream outString = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outString));

        ResultView.printFindResult(result);

        String expectedOutput = "실행 결과\n꽝\n";
        assertEquals(expectedOutput, outString.toString());

        System.setOut(System.out);
    }

    @DisplayName("결과 여러개 출력 테스트")
    @Test
    void printFindResultsTest() {
        Map<User, Result> results = new LinkedHashMap<>();
        results.put(new User("pobi"), new Result("꽝"));
        results.put(new User("honux"), new Result("3000"));
        results.put(new User("crong"), new Result("꽝"));
        results.put(new User("jk"), new Result("5000"));

        ByteArrayOutputStream outString = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outString));

        ResultView.printFindResults(results);

        String expectedOutput = "실행 결과\n" +
                "pobi : 꽝\n" +
                "honux : 3000\n" +
                "crong : 꽝\n" +
                "jk : 5000\n";
        assertEquals(expectedOutput, outString.toString());

        System.setOut(System.out);
    }
}
