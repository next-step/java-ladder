package ladderstep4.ladder.domain;

import ladder.domain.LadderPartFactory;
import ladder.enums.LadderPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderPartFactoryTest {

    @BeforeEach
    void before() {
        LadderPartFactory.setStrategy(() -> true);
    }

    @DisplayName("인덱스가 짝수면 Rail, 홀수면 Rung 생성")
    @ParameterizedTest
    @MethodSource(value = "provideIndex")
    void create(int index, LadderPart ladderPart) {
        assertThat(LadderPartFactory.ladderPart(index)).isEqualTo(ladderPart);
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
        LadderPart emptyRung = LadderPartFactory.ladderPart(3);

        assertThat(emptyRung).isEqualTo(LadderPart.EMPTY_RUNG);
    }

    @DisplayName("이전 Rung이 set되어 있지 않은 Rung이면 아무 Rung 반환")
    @Test
    void return_any_rung() {
        LadderPart anyRung = LadderPartFactory.ladderPart(3);

        assertThat(anyRung)
                .isInstanceOf(LadderPart.class)
                .isNotEqualTo(LadderPart.RAIL);
    }

    @DisplayName("strategy는 null일 수 없다.")
    @Test
    void setStrategy() {
        assertThatThrownBy(() -> LadderPartFactory.setStrategy(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LadderPartFactory.STRATEGY_NULL_MESSAGE);
    }

}
