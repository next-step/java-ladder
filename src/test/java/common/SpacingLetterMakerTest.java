package common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SpacingLetterMakerTest {

    @Test
    public void max_length() {
        assertThat(SpacingLetterMaker.makeLengthFrom("")).isEqualTo(0);

        assertThat(SpacingLetterMaker.makeLengthFrom("", "a", "abc")).isEqualTo(3);

        assertThat(SpacingLetterMaker.makeLengthFrom("bcdaaa", "a", "abc"))
            .isEqualTo(6);
    }
}