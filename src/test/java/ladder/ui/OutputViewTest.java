package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.PlayerGroup;
import ladder.domain.fixtrue.FixedLinesGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();
    private final PrintStream STANDARD_OUT = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
    }

    @AfterEach
    void tearDown() {
        System.setOut(STANDARD_OUT);
    }

    @DisplayName("사다리를 출력한다.")
    @Test
    void print_generated_lotto() {
        PlayerGroup playerGroup = PlayerGroup.from(List.of("apple", "foby", "jung", "son"));
        Ladder ladder = new Ladder(new FixedLinesGenerator());
        String expected = "" +
                " apple  foby  jung   son\n" +
                "     |-----|     |-----|\n" +
                "     |     |-----|     |\n" +
                "     |-----|     |     |\n";

        ConsoleOutput.printNamesAndLadder(playerGroup, ladder);
        String actual = OUTPUT_STREAM_CAPTOR.toString();

        assertThat(actual).isEqualTo(expected);
    }
}
