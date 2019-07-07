package ladder;

import ladder.LadderLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("현재 인덱스가 사다리 설치가 됬다면, 다음 인덱스는 반드시 설치되지 않아야 합니다.")
    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6,7,8,9,10})
    public void testIfMadeAtCurrentIdxThenNotMadeAtNextIdx() {
        List<LadderLine.LineState> establishedResults = this.ladderLine.getEstablishResults();
        List<Integer> establishedIndexes = IntStream.range(0, establishedResults.size())
                                                    .filter(index -> establishedResults.get(index) == LadderLine.LineState.ESTABLISH)
                                                    .boxed()
                                                    .collect(Collectors.toList());

        boolean isInvalid = establishedIndexes.stream()
                .map(index -> index+1)
                .anyMatch(establishedIndexes::contains);

        assertThat(isInvalid).isFalse();
    }
}
