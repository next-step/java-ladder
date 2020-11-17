package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("결과 화면 테스트")
public class ResultViewTest {
    @DisplayName("사다리 결과 타이틀 출력")
    @Test
    public void showTitle() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showTitle();

        assertThat(output.toString()).isEqualTo("사다리 결과\n\n");
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

    @DisplayName("만들어진 사다리 결과 출력")
    @Test
    public void showLadderEndPoint() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showEndPoints(Arrays.asList("꽝", "5000", "꽝", "3000"));

        assertThat(output.toString()).isEqualTo("꽝     5000  꽝     3000  \n\n");
    }

    @DisplayName("참여자 한사람의 결과 출력")
    @Test
    public void showEndPointOfMember() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showEndPointOfMember("꽝");

        assertThat(output.toString()).isEqualTo("\n실행 결과\n" +
                "꽝\n\n");
    }

    @DisplayName("전체 참여자 결과")
    @Test
    public void showAllResult() {
        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showEndPointsOfAllMembers(new LinkedHashMap<String, String>() {{
            put("pobi", "꽝");
            put("honux", "3000");
            put("crong", "꽝");
            put("jk", "5000");
        }});

        assertThat(output.toString()).isEqualTo("\n실행 결과\n" +
                "pobi : 꽝\n" +
                "honux : 3000\n" +
                "crong : 꽝\n" +
                "jk : 5000\n");
    }
}