package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static ladder.domain.Fixture.*;
import static org.junit.Assert.*;

public class PlayResultsTest {

    @Test
    public void 이름으로_결과찾기() {
        PlayResults playResults = PLAY_RESULTS;

        PlayResult result = playResults.findResultByName(HYERIN);
        Assertions.assertThat(result.isEqualsName(HYERIN)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름으로_결과찾기_없는이름() {
        PlayResults playResults = PLAY_RESULTS;
        
        playResults.findResultByName("hoho");
    }
}