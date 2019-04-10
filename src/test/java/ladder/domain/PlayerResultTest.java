package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerResultTest {

    @Test
    public void isEqualsName() {
        PlayResult playerResult = new PlayResult("hyerin", 0);
        Assertions.assertThat(playerResult.isEqualsName("hyerin")).isTrue();
    }
}