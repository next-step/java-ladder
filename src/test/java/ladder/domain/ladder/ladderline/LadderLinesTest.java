package ladder.domain.ladder.ladderline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static ladder.domain.ladder.ladderline.LadderLineTestUtil.continuousLadder;
import static ladder.domain.ladder.ladderline.LadderLineTestUtil.createNoneLadderLine;
import static org.assertj.core.api.Assertions.*;

public class LadderLinesTest {

    @Test
    void create() {
        LadderLines ladderLines = new LadderLines(List.of(createNoneLadderLine(2)));

        assertThat(ladderLines).isEqualTo(new LadderLines(List.of(createNoneLadderLine(2))));
    }

    private static Stream<Arguments> provideCustomToString() {
        return Stream.of(
                Arguments.of(new LadderLines(List.of(continuousLadder(), continuousLadder())), "    |-----|\n    |-----|"),
                Arguments.of(new LadderLines(List.of(createNoneLadderLine(2), continuousLadder())), "    |     |\n    |-----|")
        );
    }

    @ParameterizedTest(name = "LadderLine toString")
    @MethodSource("provideCustomToString")
    void custom_toString(LadderLines ladderLines, String expected) {
        assertThat(ladderLines.toString()).isEqualTo(expected);
    }
}
