package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.exception.InvalidNameLengthException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {

    @ParameterizedTest(name = "{index} \"{0}\" is invalid name")
    @NullAndEmptySource
    @ValueSource(strings = {"pororo", "\n\n", "  "})
    void of_InvalidLength(String input) {
        assertThatThrownBy(() -> PlayerName.of(input))
                .isInstanceOf(InvalidNameLengthException.class);
    }

    @Test
    void length() {
        int length = PlayerName.of("gazua").length();
        assertThat(length).isEqualTo(5);
    }
}
