package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersGameResultTest {

    private static final String index0 = "성공";
    private static final String index1 = "꽝";

    private Player player;
    private List<Score> scoreList;
    GameResult gameResult;

    @BeforeEach
    void init() {
        player = Player.from("chomi");
        scoreList = List.of(Score.of(player, 0));
        gameResult = GameResult.of(index0 + ", " + index1);

    }

    @DisplayName("점수 리스트로 생성합니다.")
    @Test
    void createWithListOfScore() {
        List<Score> scores = List.of(Score.of(player, 1));
        assertThatNoException().isThrownBy(() -> PlayersGameResult.of(scores));
    }

    @DisplayName("GameResult 로부터 실제 결과값을 알아낼 수 있습니다.")
    @Test
    void findResultByPlayer() {
        PlayersGameResult playersGameResult = PlayersGameResult.of(scoreList);

        String result = playersGameResult.findResultByPlayer(player, gameResult);
        assertThat(result).isEqualTo(index0);
    }
}
