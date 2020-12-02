package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Spoke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Stream;

import static nextstep.ladder.view.ResultView.times;
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
        resultView.printLine(new Line(Spoke.of(true, false, true)));

        assertThat(out.toString()).isEqualTo("    |-----|     |-----|\n");
    }

    @DisplayName("사다리 라인 두개를 그린다")
    @Test
    void printTwoLadderLine() {
        Ladder ladder = Ladder.of(
                Stream.of(Spoke.of(true, false, true),
                          Spoke.of(false, true, false)));

        ladder.forEach(resultView::printLine);

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
