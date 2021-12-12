package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultTest {
    @Test
    public void create() {
        final String result = "result";
        assertThat(Result.of(result)).isEqualTo(Result.of(result));
        assertThat(Result.of(result).toString()).isEqualTo(result);
    }

    @ParameterizedTest(name = "create failed : [{arguments}]")
    @NullAndEmptySource
    @ValueSource(strings = " ")
    public void createFailed(String result) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Result.of(result))
                .withMessageContaining("cannot be null or empty");
    }
}
