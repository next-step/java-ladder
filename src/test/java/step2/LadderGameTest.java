package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.LadderGame;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"5:2", "4:3", "7:3", "8:4"}, delimiter = ':')
    @DisplayName("라인 수 만큼 세로 | 라인을 만든다.")
    void ladderGameStartTest(int lineHeight, int playerCount) {
        LadderGame ladderGame = new LadderGame(lineHeight, playerCount);
        assertThat(ladderGame.getLines().size()).isEqualTo(lineHeight);
    }
}
