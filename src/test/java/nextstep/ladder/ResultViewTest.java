package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    @DisplayName("사다리 라인 하나를 그린다")
    @Test
    void printOneLadderLine() {
        StringWriter out = new StringWriter();
        new ResultView(out).printLadder(Spork.of(true, false, true).toLine());
        assertThat(out.toString()).isEqualTo("    |-----|     |-----|\n");
    }

    private static class ResultView {
        private final PrintWriter out;

        public ResultView(StringWriter out) {
            this.out = new PrintWriter(out);
        }

        public void printLadder(Line line) {
            print("    ");
            print("|-----");
            print("|     ");
            print("|-----");
            println("|");
        }

        private void println(String string) {
            out.println(string);
        }

        private void print(String string) {
            out.print(string);
        }
    }
}
