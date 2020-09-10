package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderLineTest {

    @DisplayName("LadderLine 생성")
    @ParameterizedTest
    @CsvSource(value = "3,5", delimiter = ',')
    public void createLadderLine(int playerCount, int height) {

        LadderLine ladderLine = new LadderLine(playerCount, height);
        assertNotNull(ladderLine);

        assertEquals(ladderLine.toStringList().size(), height);

        for (int i = 0; i < playerCount; i++) {
            assertThat(ladderLine.getResultOf(i))
                .isBetween(0, playerCount - 1);
        }
    }
}
