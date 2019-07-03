package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @DisplayName("ladderHeight 크기 만큼 LadderLine 이 만들어져야 합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void test(int ladderHeight) {
        int countOfColumn = 3;
        Ladder ladder = Ladder.of(countOfColumn,ladderHeight);
        List<LadderLine> ladderLines = ladder.getLadderLines();

        assertThat(ladderLines).hasSize(ladderHeight);
    }
}
