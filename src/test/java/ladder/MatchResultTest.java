package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.MatchResult;
import ladder.domain.Player;
import ladder.domain.Prize;

public class MatchResultTest {
    @Test
    void 추가_테스트() {
        // given
        MatchResult matchResult = new MatchResult();
        matchResult.addMatchResult(new Player(0, "dhlee"), new Prize(0, "1000"));
        matchResult.addMatchResult(new Player(1, "test"), new Prize(1, "1000"));

        // when & then
        assertThat(matchResult.getMatchResult().size()).isEqualTo(2);
    }

    @Test
    void 플레이어_이름_매칭_테스트() {
        // given
        Player player1 = new Player(0, "dhlee");
        Player player2 = new Player(1, "test");
        Prize prize1 = new Prize(0, "1000");
        Prize prize2 = new Prize(1, "2000");

        MatchResult matchResult = new MatchResult();
        matchResult.addMatchResult(player1, prize1);
        matchResult.addMatchResult(player2, prize2);

        // when & then
        assertThat(matchResult.matchPlayer(player1)).isEqualTo(prize1);
        assertThat(matchResult.matchPlayer(player2)).isEqualTo(prize2);
    }
}
