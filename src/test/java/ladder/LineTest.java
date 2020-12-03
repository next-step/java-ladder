package ladder;

import ladder.model.LadderItem;
import ladder.model.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @ParameterizedTest
    @MethodSource("generateErrorLadder")
    public void 비정상_사다리(List<LadderItem> ladderItems) {
        assertThatThrownBy(() -> Line.from(ladderItems)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateLadder")
    public void 정상_사다리(List<LadderItem> ladderItems) {
        assertThat(Line.from(ladderItems));
    }

    private static Stream<List<LadderItem>> generateErrorLadder() {
        return Stream.of(
                Arrays.asList(LadderItem.HORIZONTAL, LadderItem.HORIZONTAL),
                Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.HORIZONTAL, LadderItem.HORIZONTAL),
                Arrays.asList(LadderItem.HORIZONTAL, LadderItem.HORIZONTAL, LadderItem.BLANK_HORIZONTAL)
        );
    }

    private static Stream<List<LadderItem>> generateLadder() {
        return Stream.of(
                Arrays.asList(LadderItem.HORIZONTAL, LadderItem.BLANK_HORIZONTAL),
                Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.HORIZONTAL),
                Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.BLANK_HORIZONTAL)
        );
    }

}
