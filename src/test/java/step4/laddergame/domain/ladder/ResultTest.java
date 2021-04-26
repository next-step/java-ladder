package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    void 결과하나생성() {
        assertThat(Result.of("꽝")).isEqualTo(new Result("꽝"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 결과는비어있을수없다(String input) {
        assertThatThrownBy(() -> {
            Result.of(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
