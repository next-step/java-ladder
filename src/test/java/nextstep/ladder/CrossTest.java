package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CrossTest {

    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(false, true, 1),
                Arguments.of(true, false, -1),
                Arguments.of(false, false, 0));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("move_method_test")
    public void move_method_test(boolean last, boolean current, int result) {
        Cross cross = new Cross(last, current);
        assertThat(cross.move(0)).isEqualTo(result);
    }
}
