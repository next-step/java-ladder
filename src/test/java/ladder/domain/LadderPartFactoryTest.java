package ladder.domain;

import ladder.enums.LadderPart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPartFactoryTest {

    @DisplayName("짝수는 Rail, 홀수는 Rung")
    @ParameterizedTest
    @MethodSource(value = "provideIndex")
    void create(int idx, LadderPart ladderPart) {
        assertThat(LadderPartFactory.ladderPart(idx, () -> true)).isEqualTo(ladderPart);
    }

    private static Stream<Arguments> provideIndex() {
        return Stream.of(
                Arguments.of(0, LadderPart.RAIL),
                Arguments.of(1, LadderPart.RUNG)
        );
    }

    @DisplayName("이전 Rung이 set되어 있는 Rung이면 emptyRung 반환")
    @Test
    void return_emptyRung() {
        LadderPartFactory.changeIsPreviousRungSet(true);
        LadderPart emptyRung = LadderPartFactory.ladderPart(3, () -> true);

        assertThat(emptyRung).isEqualTo(LadderPart.EMPTY_RUNG);
    }

    @DisplayName("이전 Rung이 set되어 있지 않은 Rung이면 아무 Rung 반환")
    @Test
    void return_any_rung() {
        LadderPart anyRung = LadderPartFactory.ladderPart(3, () -> true);

        assertThat(anyRung)
                .isInstanceOf(LadderPart.class)
                .isNotEqualTo(LadderPart.RAIL);
    }

}
