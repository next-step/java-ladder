package console;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;

public class SpacingLetterHelperTest {

    @Test
    public void spacingLetterLength_greater_than_longest_name() {
        final String longestName = "loooong";

        assertThat(SpacingLetterHelper.makeLengthFrom(Arrays.asList("", "a", longestName))).isGreaterThan(longestName.length());
    }
}