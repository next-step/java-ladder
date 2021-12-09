package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1, 10})
    public void create(int numberOfPlayer) {
        assertThat(Line.of(numberOfPlayer)).isEqualTo(Line.of(numberOfPlayer));
    }

//    @ParameterizedTest(name = "create failed: {arguments}")
//    @NullSource
//    public void createFailed(Height height) {
//        assertThatIllegalArgumentException()
//                .isThrownBy(() -> Line.of(height))
//                .withMessageContaining("cannot be null");
//    }
}
