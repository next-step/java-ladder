package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private static final int MOCK_COUNT_OF_PERSON_NUMBER = 5;

    private LadderLine ladderLine;

    @BeforeEach
    public void setUp() {
        this.ladderLine = LadderLine.of(MOCK_COUNT_OF_PERSON_NUMBER);
    }

    @DisplayName("다리가 설치된 결과 값은 사람 수 보다 하나 적어야 합니다.")
    @Test
    public void testIfMadeAtCurrentIdxThenNotMadeAtNextIdx() {
        List<Boolean> columnResultsOfLadderLine = this.ladderLine.getColumnResultsOfLadderLine();

        assertThat(columnResultsOfLadderLine.size()).isEqualTo(MOCK_COUNT_OF_PERSON_NUMBER - 1);
    }
}
