package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @DisplayName("사다리를 출력한다.")
    @Test
    public void testPrintLadder() {
        Ladder ladder = new Ladder(4, 5, List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(false, true, false),
                List.of(true, false, true)
        ));

        ByteArrayOutputStream outString = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outString));

        ladder.printLadder();

        String expectedOutput = "    |-----|     |-----|\n" +
                "    |     |-----|     |\n" +
                "    |-----|     |     |\n" +
                "    |     |-----|     |\n" +
                "    |-----|     |-----|\n";
        assertEquals(expectedOutput, outString.toString());

        System.setOut(System.out);
    }
}
