package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayResultsTest {

    @Test
    public void 이름으로_결과찾기() {

        PlayResults playResults = new PlayResults(Arrays.asList(new PlayResult("hyerin", 0),
                                                                new PlayResult("isisrin", 1)));

        PlayResult result = playResults.findResultByName("hyerin");
        Assertions.assertThat(result.isEqualsName("hyerin")).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름으로_결과찾기_없는이름() {

        PlayResults playResults = new PlayResults(Arrays.asList(new PlayResult("hyerin", 0),
                new PlayResult("isisrin", 1)));

        PlayResult result = playResults.findResultByName("hoho");
    }
}