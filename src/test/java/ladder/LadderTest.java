package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderTest {

    @DisplayName("Ladder 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = "5,5", delimiter = ',')
    public void ladderTest(int playerCount, int height) {

        Ladder ladder = new Ladder(playerCount, height);

        assertNotNull(ladder.getLadderLine());

        assertThat(ladder.getLadderLine())
            .isInstanceOf(LadderLine.class);

        assertEquals(ladder.getLadderLinesString().size(), height);
    }
}
