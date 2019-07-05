package nextstep.step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void create_ladder() {
        assertThat(new Ladder(List.of()).getLines().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("게임 결과 조회")
    void get_game_result() {
        final var players = Players.create(List.of("choe", "bk", "next"));
        LadderGame game = new LadderGame(players, 5);
        GameResults results = GameResults.create(List.of("꽝", "꽝", "꽝"));
        assertThat(game.start().getPlayerRewards(players, results).get(players.findByName("bk")).toString()).isEqualTo("꽝");
    }
}
