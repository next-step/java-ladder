package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.reword.Rewords;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerFactory;
import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderResultTest {

    @DisplayName("결과를 보고 싶은 사람을 볼 수 있다.")
    @Test
    void playerResult() {
        // given
        Players players = PlayerFactory.playerFixture("pobi1", "pobi2", "pobi3");

        Line line = Line.from(Arrays.asList(true, false));

        Ladder ladder = Ladder.of(line);

        List<String> results = Arrays.asList("꽝", "5000", "2000");

        Rewords rewords = Rewords.from(results);

        // when
        LadderResult ladderResult = LadderResult.of(ladder, rewords);
        Player pobi1 = players.findIndexByName("pobi1");
        Player pobi2 = players.findIndexByName("pobi2");
        Player pobi3 = players.findIndexByName("pobi3");


        // then
       assertAll(() -> {
            assertThat(ladderResult.result(pobi1)).isEqualTo("5000");
            assertThat(ladderResult.result(pobi2)).isEqualTo("꽝");
            assertThat(ladderResult.result(pobi3)).isEqualTo("2000");
        });
    }
}

