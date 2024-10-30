package nextstep.ladder;

import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.Gamers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameResultTest {

    @Test
    void 게임결과와_참여자수_일치() {
        Gamers gamers = new Gamers("Anna,Max,Tom");
        GameResult gameResult = new GameResult(List.of("Win,Lose,Draw"));

        assertThat(gameResult.validateGameResultCount(gamers)).isEqualTo(true);
    }

    @Test
    void 게임결과와_참여자수_불일치시_예외발생() {
        Gamers gamers = new Gamers("Anna,Max,Tom");
        GameResult gameResult = new GameResult(List.of("Win,Lose"));

        assertThatThrownBy(() -> gameResult.validateGameResultCount(gamers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 결과와 참여자 인원 수가 다릅니다.");
    }
}
