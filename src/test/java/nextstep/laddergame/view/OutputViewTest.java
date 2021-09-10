package nextstep.laddergame.view;

import nextstep.laddergame.domain.PlayerName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private ByteArrayOutputStream out;
    private OutputView outputView;

    @BeforeEach
    public void setup() {
        out = new ByteArrayOutputStream();
        outputView = OutputView.of(new PrintStream(out));
    }

    @ParameterizedTest(name = "실행 결과 출력 테스트")
    @CsvSource(value = {"yunb,1000", "noone,존재하지 않는 이름입니다.", "all,yunb : 1000"})
    public void printPlayResultTest(String input, String output) {
        Map<PlayerName, String> results = Collections.singletonMap(PlayerName.of("yunb"), "1000");
        outputView.printPlayResult(results, input);
        assertThat(out.toString())
                .contains(output);
    }


}