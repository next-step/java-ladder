package console;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;

public class SpacingLetterHelperTest {

    @Test
    public void max_length() {
        assertThat(SpacingLetterHelper.makeLengthFrom(Arrays.asList(""))).isEqualTo(0);

        assertThat(SpacingLetterHelper.makeLengthFrom(Arrays.asList("", "a", "abc"))).isEqualTo(3);

        assertThat(SpacingLetterHelper.makeLengthFrom(Arrays.asList("bcdaaa", "a", "abc")))
            .isEqualTo(6);
    }
}