package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PrizesTest {
    @Test
    void 유효한_이름으로_Prizes생성_콤마로구분() {
        assertDoesNotThrow(() -> new Prizes("꽝,5000,꽝,3000"));
    }

    @ParameterizedTest
    @MethodSource(value = "providePositionAndPrize")
    void 포지션에_해당하는_Prize_반환(int value, String prize) {
        Prizes prizes = new Prizes("꽝,5000,꽝,3000");
        assertThat(prizes.findPrize(new Position(value))).isEqualTo(new Prize(prize));
    }

    private static Stream<Arguments> providePositionAndPrize() {
        return Stream.of(
                Arguments.of(0, "꽝"),
                Arguments.of(1, "5000"),
                Arguments.of(2, "꽝"),
                Arguments.of(3, "3000")
        );
    }

    @Test
    void 유효하지않은_포지션으로_Prize찾기_예외발생() {
        Prizes prizes = new Prizes("꽝,5000,꽝,3000");

        assertThatThrownBy(() -> prizes.findPrize(new Position(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Prizes.CANNOT_FIND_PRIZE_MESSAGE);
    }
}
