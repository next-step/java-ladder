package ladder;

import ladder.model.LadderItem;
import ladder.model.Line;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @ParameterizedTest
    @MethodSource("generateErrorLadderItems")
    public void 비정상_사다리(List<LadderItem> ladderItems) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.from(ladderItems))
                .withMessageMatching("올바르지 못한 라인입니다.");
    }

    @ParameterizedTest
    @MethodSource("generateLadderItems")
    public void 정상_사다리(List<LadderItem> ladderItems) {
        assertThat(Line.from(ladderItems));
    }

    private static Stream<List<LadderItem>> generateErrorLadderItems() {
        return Stream.of(
                Arrays.asList(LadderItem.HORIZONTAL, LadderItem.HORIZONTAL),
                Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.HORIZONTAL, LadderItem.HORIZONTAL),
                Arrays.asList(LadderItem.HORIZONTAL, LadderItem.HORIZONTAL, LadderItem.BLANK_HORIZONTAL)
        );
    }

    private static Stream<List<LadderItem>> generateLadderItems() {
        return Stream.of(
                Arrays.asList(LadderItem.HORIZONTAL, LadderItem.BLANK_HORIZONTAL),
                Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.HORIZONTAL),
                Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.BLANK_HORIZONTAL)
        );
    }

}
