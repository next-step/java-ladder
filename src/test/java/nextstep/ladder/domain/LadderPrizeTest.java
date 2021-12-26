package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderPrizeTest {
    @Test
    public void create() {
        final String prize = "result";
        assertThat(LadderPrize.of(prize)).isEqualTo(LadderPrize.of(prize));
        assertThat(LadderPrize.of(prize).toString()).isEqualTo(prize);
    }

    @ParameterizedTest(name = "create failed : [{arguments}]")
    @NullAndEmptySource
    @ValueSource(strings = " ")
    public void createFailed(String result) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPrize.of(result))
                .withMessageContaining("cannot be null or empty");
    }

    public static LadderPrize pz(String result) {
        return LadderPrize.of(result);
    }
}
