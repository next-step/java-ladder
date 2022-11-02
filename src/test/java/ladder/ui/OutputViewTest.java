package ladder.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("주어진 로또의 개수와, 로또 숫자들을 출력한다.")
    @Test
    void print_generated_lotto() {

//        OutputView.printGeneratedLottos(lottoPaper);
//        String actual = outputStreamCaptor.toString();
//
//        assertThat(actual).isEqualTo(expected);
    }
}
