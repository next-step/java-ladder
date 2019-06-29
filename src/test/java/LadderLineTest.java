import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderLineTest {
    private static final int MOCK_COUNT_OF_PERSON_NUMBER = 5;

    private LadderLine ladderLine;

    @BeforeEach
    public void setUp() {
        this.ladderLine = LadderLine.of(MOCK_COUNT_OF_PERSON_NUMBER);
    }

    @DisplayName("현재 인덱스가 사다리 설치가 됬다면, 다음 인덱스는 반드시 설치되지 않아야 합니다.")
    @Test
    public void testIfMadeAtCurrentIdxThenNotMadeAtNextIdx() {
        List<Integer> establishedIndexes = this.ladderLine.getEstablishIndexes();
        boolean isInvalid = establishedIndexes.stream()
                .map(index -> index+1)
                .anyMatch(establishedIndexes::contains);

        assertThat(isInvalid).isFalse();
    }
}
