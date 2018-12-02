package ladder.model;

import org.junit.Before;
import org.junit.Test;

import static ladder.model.LadderTest.DEFAULT_LADDER;
import static ladder.model.ParticipantsTest.DEFAULT_PARTICIPANTS;
import static ladder.model.ResultItemsTest.DEFAULT_RESULT_ITEMS;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;

    @Before
    public void setUp() throws Exception {
        ladderGame = new LadderGame(DEFAULT_LADDER);
    }

    @Test
    public void 생성() {
        assertThat(ladderGame).isNotNull();
    }

    @Test
    public void 플레이() {
        assertThat(ladderGame.play(1)).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이_사다리의_포인트수와_참가자수가_일치하지_않는_경우() {
        ladderGame.play(Participants.fromComma("a,b,c"), ResultItems.fromComma("꽝, 3000, 꽝, 2000, 4000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이_사다리의_포인트수와_결과수가_일치하지_않는_경우() {
        ladderGame.play(Participants.fromComma("a,b,c,d,e"), ResultItems.fromComma("꽝, 3000, 꽝, 2000"));
    }
}