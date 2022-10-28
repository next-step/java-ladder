package ladder.view.output;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LadderCreateOutputViewTest {

    @ParameterizedTest(name = "사람 이름이 5자 미만일 경우 공백을 채워 5자로 출력한다.")
    @ValueSource(strings = {"a","ab","abc","abcd","abcde"})
    void personname_output(String text) {
        assertThat(LadderCreateOutputView.outputPersonName(text).length()).isEqualTo(5);
    }
}
