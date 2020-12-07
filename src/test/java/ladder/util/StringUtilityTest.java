package ladder.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilityTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void testBlank(String inputData) {
        //Given & When
        boolean expected = StringUtility.isBlank(inputData);

        //Then
        assertThat(expected).isTrue();
    }
}
