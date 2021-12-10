package ladder.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPartTest {

    @DisplayName("boolean 값에 따른 rung 생성 테스트")
    @ParameterizedTest
    @MethodSource(value = "provideBoolean")
    void from(boolean isPreviousRungSet, LadderPart expected) {
        assertThat(LadderPart.from(isPreviousRungSet)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBoolean() {
        return Stream.of(
                Arguments.of(true, LadderPart.RUNG),
                Arguments.of(false, LadderPart.EMPTY_RUNG)
        );
    }

    @Test
    void isRail() {
        assertThat(LadderPart.RAIL.isRail()).isTrue();
        assertThat(LadderPart.RUNG.isRail()).isFalse();
        assertThat(LadderPart.EMPTY_RUNG.isRail()).isFalse();
    }

    @Test
    void isRung() {
        assertThat(LadderPart.RUNG.isRung()).isTrue();
        assertThat(LadderPart.RAIL.isRung()).isFalse();
        assertThat(LadderPart.EMPTY_RUNG.isRung()).isFalse();
    }

}
