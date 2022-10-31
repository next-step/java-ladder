package ladder.util;

import ladder.domain.result.Results;
import ladder.domain.ladder.ladderline.LadderLines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static ladder.testutil.LadderLineTestUtil.continuousLadder;
import static ladder.testutil.LadderLineTestUtil.createNoneLadderLine;
import static org.assertj.core.api.Assertions.*;

public class LadderOutputConverterTest {

    private static Stream<Arguments> provideCustomToString() {
        return Stream.of(
                Arguments.of(new LadderLines(List.of(continuousLadder(), continuousLadder())), "    |-----|\n    |-----|"),
                Arguments.of(new LadderLines(List.of(createNoneLadderLine(2), continuousLadder())), "    |     |\n    |-----|")
        );
    }

    @ParameterizedTest(name = "LadderLine toString")
    @MethodSource("provideCustomToString")
    void ladders_custom_toString(LadderLines ladderLines, String expected) {
        assertThat(LadderOutputConverter.ladderLinesOutput(ladderLines)).isEqualTo(expected);
    }


    @DisplayName("5자 미만일 경우 공백을 채워 5자로 출력한다.")
    @Test
    void result_output() {
        Results results = new Results("꽝", "5000", "3000");

        assertThat(LadderOutputConverter.ladderTextOutput(results.results())).isEqualTo("    꽝  5000  3000");
    }


    @ParameterizedTest(name = "사람 이름이 5자 미만일 경우 공백을 채워 5자로 출력한다.")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void personname_output(String text) {
        assertThat(LadderOutputConverter.outputPersonName(text).length()).isEqualTo(5);
    }
}
