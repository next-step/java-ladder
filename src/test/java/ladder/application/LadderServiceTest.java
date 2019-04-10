package ladder.application;

import ladder.domain.LadderGame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {
    private LadderService ladderService;

    @Before
    public void setUp() {
        this.ladderService = new LadderService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 혼자서_사다리_게임() {
        // given
        // when
        // then
        ladderService.make("pobi", 5);
    }

    @Test
    public void 사다리_게임_생성() {
        // given
        final String inputName = "pobi,honux,crong,jk";
        final int height = 5;

        // when
        final LadderGame ladderGame = ladderService.make(inputName, height);

        // then
        assertThat(ladderGame).isNotNull();
    }
}