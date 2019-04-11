package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static ladder.domain.Fixture.HYERIN;
import static ladder.domain.Fixture.HYERIN_PLAY_RESULT;
import static org.junit.Assert.*;

public class PlayerResultTest {

    @Test
    public void isEqualsName() {
        PlayResult playerResult = HYERIN_PLAY_RESULT;
        Assertions.assertThat(playerResult.isEqualsName(HYERIN)).isTrue();
    }
}