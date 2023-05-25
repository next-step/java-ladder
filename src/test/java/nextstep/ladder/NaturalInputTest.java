package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NaturalInputTest {
    @ParameterizedTest
    @ValueSource(strings = {"12wr23", "       "})
    public void throwErrorOnInvalidInputs(String input) {
        assertThatThrownBy(() -> new NaturalInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input is not a natural number");
    }

    @Test
    public void convertsInputToNatural() {
        var input = "5";

        var natural = new NaturalInput(input).toNatural();

        assertThat(natural.value()).isEqualTo(5L);
    }
}
