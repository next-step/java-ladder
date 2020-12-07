package ladder.domain.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-04.
 */
public class LineTest {

    private static Stream<List<Boolean>> provideConstructLine() {
        return Stream.of(
                Arrays.asList(true, false, true),
                Arrays.asList(true, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConstructLine")
    void 사다리_한_줄_생성(List<Boolean> inputBridges) {
        assertThat(Line.of(inputBridges)).isEqualTo(Line.of(inputBridges));
    }

    private static Stream<List<Boolean>> provideConstructDuplicatedLine() {
        return Stream.of(
                Arrays.asList(true, true, false),
                Arrays.asList(false, true, true, false),
                Arrays.asList(true, false, true, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConstructDuplicatedLine")
    void 사다리_브릿지가_겹치면_예외처리(List<Boolean> inputBridges) {
        assertThatThrownBy(() -> Line.of(inputBridges))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Line.MESSAGE_BRIDGES_DUPLICATED);
    }

}
