package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @DisplayName("라인을 출력한다.")
    @Test
    public void testPrintLine() {
        Line line = new Line(4, List.of(true, false, true));

        ByteArrayOutputStream outString = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outString));

        line.printLine();

        String expectedOutput = "    |-----|     |-----|\n";
        assertEquals(expectedOutput, outString.toString());

        System.setOut(System.out);
    }
}
