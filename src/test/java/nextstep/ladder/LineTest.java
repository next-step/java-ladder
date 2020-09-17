package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LineTest {

    @ParameterizedTest
    @MethodSource("provideDisconnected")
    @DisplayName("팩토리 메소드 정상 작동")
    void create(List<Boolean> connections) {
        assertNotNull(connections);
    }

    private static Stream<List<Boolean>> provideDisconnected() {
        return Stream.of(
                Arrays.asList(false, false, false),
                Arrays.asList(true, false, false),
                Arrays.asList(false, true, false),
                Arrays.asList(false, false, true),
                Arrays.asList(true, false, true),
                Arrays.asList(false, false, false, false),
                Arrays.asList(true, false, false, false),
                Arrays.asList(false, true, false, false),
                Arrays.asList(false, false, true, false),
                Arrays.asList(false, false, false, true),
                Arrays.asList(true, false, true, false),
                Arrays.asList(false, true, false, true),
                Arrays.asList(true, false, false, true),
                Arrays.asList(false, false, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConnected")
    @DisplayName("팩토리 메소드 예외 발생")
    void create_validate(List<Boolean> connections) {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(connections));
    }

    private static Stream<List<Boolean>> provideConnected() {
        return Stream.of(
                Arrays.asList(true, true, true),
                Arrays.asList(true, true, false),
                Arrays.asList(false, true, true),
                Arrays.asList(true, true, true, true),
                Arrays.asList(false, true, true, true),
                Arrays.asList(false, true, true, false),
                Arrays.asList(false, false, true, true),
                Arrays.asList(true, false, true, true),
                Arrays.asList(true, true, false, true),
                Arrays.asList(true, true, true, false),
                Arrays.asList(true, true, false, false)
        );
    }
}
