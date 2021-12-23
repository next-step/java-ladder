package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizeTest {
    @Test
    public void create() {
        final String prize = "result";
        assertThat(Prize.of(prize)).isEqualTo(Prize.of(prize));
        assertThat(Prize.of(prize).toString()).isEqualTo(prize);
    }

    @ParameterizedTest(name = "create failed : [{arguments}]")
    @NullAndEmptySource
    @ValueSource(strings = " ")
    public void createFailed(String result) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prize.of(result))
                .withMessageContaining("cannot be null or empty");
    }

    public static Prize pz(String result) {
        return Prize.of(result);
    }
}
