package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    void 게임결과찾기() {
        Ladder ladder = new Ladder(List.of(new Line(List.of(true, false)),
                new Line(List.of(false, true)),
                new Line(List.of(true, false))));
        Participants participants = Participants.generateParticipants(new String[]{"aaa", "bbb", "ccc"});
        GamePrize gamePrize = GamePrize.generateGamePrize(new String[]{"꽝", "1000", "3000"});

        GameResult gameResult = GameResult.of(ladder, participants, gamePrize);
        assertThat(gameResult.getResult().get(new Name("aaa"))).isEqualTo(new Prize("3000"));
        assertThat(gameResult.getResult().get(new Name("bbb"))).isEqualTo(new Prize("1000"));
        assertThat(gameResult.getResult().get(new Name("ccc"))).isEqualTo(new Prize("꽝"));
    }
}
