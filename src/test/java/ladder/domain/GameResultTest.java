package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameResultTest {

    @DisplayName("GameResult객체 생성 테스트")
    @Test
    void GameResult객체_생성() {
        String[] gameResults = {"꽝", "1000", "2000"};
        GameResult gameResult = GameResult.create(Arrays.asList(gameResults));
        assertThat(gameResult.size()).isEqualTo(gameResult.size());
    }

    @DisplayName("GameResult객체 생성 테스트_비어있는경우")
    @Test
    void GameResult객체_생성_비어있는경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameResult.create(null))
                .withMessageMatching("GameResult is Empty");
    }

}
