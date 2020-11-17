package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("결과 화면 테스트")
public class ResultViewTest {
    @DisplayName("실행 결과 타이틀 출력")
    @Test
    public void showTitle() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showTitle();

        assertThat(output.toString()).isEqualTo("실행결과\n\n");
    }

    @DisplayName("참여자 출력")
    @Test
    public void showMember() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showMemberNames(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThat(output.toString()).isEqualTo("  pobi honux crong    jk\n");
    }

    @DisplayName("사다리 출력")
    @Test
    public void showResult() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showLadder(
                Arrays.asList(
                        Line.of(Arrays.asList(false, true, false, true)),
                        Line.of(Arrays.asList(false, false, true, false)),
                        Line.of(Arrays.asList(false, true, false, false)),
                        Line.of(Arrays.asList(false, false, true, false)),
                        Line.of(Arrays.asList(false, true, false, true))
                ));

        assertThat(output.toString()).isEqualTo(
                "     |-----|     |-----|\n" +
                        "     |     |-----|     |\n" +
                        "     |-----|     |     |\n" +
                        "     |     |-----|     |\n" +
                        "     |-----|     |-----|\n");
    }
}