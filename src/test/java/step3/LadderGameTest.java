package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.LadderGame;
import step3.model.Line;
import step3.model.PointRandomStrategy;
import step3.teststrategy.PointTrueStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"5:2", "4:3", "7:3", "8:4"}, delimiter = ':')
    @DisplayName("라인 수 만큼 세로 | 라인을 만든다.")
    void ladderGameStartTest(int lineHeight, int playerCount) {
        LadderGame ladderGame = LadderGame.start(lineHeight, playerCount, new PointRandomStrategy());
        assertThat(ladderGame.getLines().size()).isEqualTo(lineHeight);
    }
}
