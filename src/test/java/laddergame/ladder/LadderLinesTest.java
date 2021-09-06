package laddergame.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인들은")
class LadderLinesTest {

    private static final int USER_COUNT = 4;

    private List<LadderLine> ladderLines;

    @BeforeEach
    void setUp() {
        ladderLines = Arrays.asList(new LadderLine(USER_COUNT), new LadderLine(USER_COUNT), new LadderLine(USER_COUNT));
    }

    @DisplayName("라인 여러개로 초기화된다.")
    @Test
    void create() {
        assertThat(new LadderLines(ladderLines)).isEqualTo(new LadderLines(ladderLines));
    }
}
