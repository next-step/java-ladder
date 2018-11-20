package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LadderResultTest {
    private LadderResult ladderResult;
    
    @Before
    public void setup() {
        ladderResult = new LadderResult();
        ladderResult.put(Player.of("korna"), Result.of("꽝"));
        ladderResult.put(Player.of("hee"), Result.of("1000"));
    }

    @Test
    public void 참가자_결과_조회() {
        assertThat(ladderResult.get(Player.of("hee"))).isEqualTo(Result.of("1000"));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void 미참가자_결과_조회() {
        assertThat(ladderResult.get(Player.of("user"))).isEqualTo(Result.of("1000"));
    }
    
    @Test
    public void 참가자들_조회() {
        Set<Player> players = ladderResult.keyset();
        assertThat(players).contains(Player.of("korna"), Player.of("hee"));
    }
}
