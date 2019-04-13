package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static ladder.domain.Fixture.*;
import static org.junit.Assert.*;

public class PlayResultsTest {

    @Test
    public void 플레이어로_결과찾기() {
        PlayResults playResults = PLAY_RESULTS;

        PlayResult result = playResults.findResultByPlayer(HYERIN_PLAYER);
        Assertions.assertThat(result.isEqualsName(HYERIN)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어로_결과찾기_없는플레이어() {
        PlayResults playResults = PLAY_RESULTS;
        playResults.findResultByPlayer(new Player("끄오옼"));
    }
}