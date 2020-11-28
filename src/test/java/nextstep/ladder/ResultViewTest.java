package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static nextstep.ladder.ResultViewTest.ResultView.times;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    @DisplayName("사다리 라인 하나를 그린다")
    @Test
    void printOneLadderLine() {
        StringWriter out = new StringWriter();
        new ResultView(out).printLadder(Spoke.of(true, false, true).toLine());
        assertThat(out.toString()).isEqualTo("    |-----|     |-----|\n");
    }

    @Test
    void timesForString() {
        assertThat(times("-", 5)).isEqualTo("-----");
    }

    static class ResultView {
        public static final String BLANK = " ";
        public static final String POLE = "|";
        public static final String RUNG = "-";
        private final PrintWriter out;

        public ResultView(StringWriter out) {
            this.out = new PrintWriter(out);
        }

        public void printLadder(Line line) {
            print(times(BLANK, 4));
            line.toSpokeStream()
                    .map(spokeExists -> {
                        if (spokeExists) {
                            return makeRung();
                        }
                        return makeEmptyRung();
                    })
                    .map(this::withPole)
                    .forEach(this::print);
            println("|");
        }

        private String withPole(String rung) {
            return POLE + rung;
        }

        private String makeEmptyRung() {
            return times(BLANK, 5);
        }

        private String makeRung() {
            return times(RUNG, 5);
        }

        private void println(String string) {
            out.println(string);
        }

        private void print(String string) {
            out.print(string);
        }

        static String times(String string, int repeat) {
            return IntStream.range(0, repeat).mapToObj(__ -> string).collect(joining());
        }
    }
}
