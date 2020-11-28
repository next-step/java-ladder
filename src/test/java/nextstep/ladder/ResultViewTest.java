package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.ResultView.times;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private StringWriter out;
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        out = new StringWriter();
        resultView = new ResultView(out);
    }

    @DisplayName("사다리 라인 하나를 그린다")
    @Test
    void printOneLadderLine() {
        resultView.printLadder(Spoke.of(true, false, true).toLine());

        assertThat(out.toString()).isEqualTo("    |-----|     |-----|\n");
    }

    @DisplayName("사다리 라인 두개를 그린다")
    @Test
    void printTwoLadderLine() {
        List<Line> lines = Arrays.asList(
                Spoke.of(true, false, true).toLine(),
                Spoke.of(false, true, false).toLine());

        resultView.printLadders(lines);

        assertThat(out.toString()).isEqualTo(
                "    |-----|     |-----|\n" +
                "    |     |-----|     |\n"
        );
    }

    @DisplayName("이름을 그린다")
    @Test
    void printNames() {
        resultView.printNames(Arrays.asList("white", "blue", "green", "red"));

        assertThat(out.toString()).isEqualTo(
                "white  blue green   red\n"
        );
    }

    @Test
    void timesForString() {
        assertThat(times("-", 5)).isEqualTo("-----");
    }

}
