package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    private Result result;

    @Test
    void 결과하나생성() {
        result = new Result("꽝");
        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 결과는비어있을수없다(String input) {
        assertThatThrownBy(() -> {
            new Result(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
