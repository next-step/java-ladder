package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Fixture;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 행에서 기둥을 담당하는 컬럼 클래스 테스트")
class LadderColumnTest {

    @DisplayName("기본적으로 컬럼은 발판 생성 전략을 가지고 초기화를 한다.")
    @Test
    void init() {
        assertThat(LadderColumn.initFirst(ALWAYS_GENERATE_STRATEGY)).isInstanceOf(LadderColumn.class);
    }

    @DisplayName("하나의 열에는 오른쪽 발판이 있거나 없다.")
    @MethodSource
    @ParameterizedTest
    void hasRightStep(StepGenerateStrategy stepGenerateStrategy, boolean expectedValue) {
        LadderColumn ladderColumn = LadderColumn.initFirst(stepGenerateStrategy);

        assertThat(ladderColumn.hasRightStep()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> hasRightStep() {
        return Stream.of(
                Arguments.of(ALWAYS_GENERATE_STRATEGY, true),
                Arguments.of(NEVER_GENERATE_STRATEGY, false)
        );
    }

    @DisplayName("첫번 째 컬럼은 오른쪽 발판을 가지거나 발판을 가지지 않는다.")
    @MethodSource
    @ParameterizedTest
    void initFirstColumn(StepGenerateStrategy stepGenerateStrategy, LadderColumn expectedLadderColumn) {
        LadderColumn ladderColumn = LadderColumn.initFirst(stepGenerateStrategy);

        assertThat(ladderColumn).isEqualTo(expectedLadderColumn);
    }

    private static Stream<Arguments> initFirstColumn() {
        return Stream.of(
                Arguments.of(ALWAYS_GENERATE_STRATEGY, RIGHT_STEP_LADDER_COLUMN),
                Arguments.of(NEVER_GENERATE_STRATEGY, NONE_STEP_LADDER_COLUMN)
        );
    }

    @DisplayName("두번째 부터 마지막 전 컬럼 까지는 이전 컬럼의 스텝 종류와 발판 생성 전략에 영향을 받아 생성한다.")
    @MethodSource
    @ParameterizedTest
    void initMiddleColumn(LadderColumn prevLadderColumn, StepGenerateStrategy stepGenerateStrategy, LadderColumn expectedLadderColumn) {
        LadderColumn ladderColumn = prevLadderColumn.initNext(stepGenerateStrategy);

        assertThat(ladderColumn).isEqualTo(expectedLadderColumn);
    }

    private static Stream<Arguments> initMiddleColumn() {
        return Stream.of(
                Arguments.of(Fixture.RIGHT_STEP_LADDER_COLUMN, ALWAYS_GENERATE_STRATEGY, Fixture.LEFT_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.RIGHT_STEP_LADDER_COLUMN, NEVER_GENERATE_STRATEGY, Fixture.LEFT_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.LEFT_STEP_LADDER_COLUMN, ALWAYS_GENERATE_STRATEGY, Fixture.RIGHT_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.LEFT_STEP_LADDER_COLUMN, NEVER_GENERATE_STRATEGY, Fixture.NONE_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.NONE_STEP_LADDER_COLUMN, ALWAYS_GENERATE_STRATEGY, Fixture.RIGHT_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.NONE_STEP_LADDER_COLUMN, NEVER_GENERATE_STRATEGY, Fixture.NONE_STEP_LADDER_COLUMN)
        );
    }

    @DisplayName("마지막 컬럼은 이전 컬럼의 스텝 종류에 영향을 받아 생성한다.")
    @MethodSource
    @ParameterizedTest
    void initLastColumn(LadderColumn prevLadderColumn, StepGenerateStrategy stepGenerateStrategy, LadderColumn expectedLadderColumn) {
        LadderColumn ladderColumn = prevLadderColumn.initLast(stepGenerateStrategy);

        assertThat(ladderColumn).isEqualTo(expectedLadderColumn);
    }

    private static Stream<Arguments> initLastColumn() {
        return Stream.of(
                Arguments.of(Fixture.RIGHT_STEP_LADDER_COLUMN, ALWAYS_GENERATE_STRATEGY, Fixture.LEFT_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.LEFT_STEP_LADDER_COLUMN, ALWAYS_GENERATE_STRATEGY, Fixture.NONE_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.NONE_STEP_LADDER_COLUMN, ALWAYS_GENERATE_STRATEGY, Fixture.NONE_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.RIGHT_STEP_LADDER_COLUMN, NEVER_GENERATE_STRATEGY, Fixture.LEFT_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.LEFT_STEP_LADDER_COLUMN, NEVER_GENERATE_STRATEGY, Fixture.NONE_STEP_LADDER_COLUMN),
                Arguments.of(Fixture.NONE_STEP_LADDER_COLUMN, NEVER_GENERATE_STRATEGY, Fixture.NONE_STEP_LADDER_COLUMN)
        );
    }

    @DisplayName("마지막 컬럼은 이전 컬럼의 스텝 종류에 영향을 받아 생성한다.")
    @MethodSource
    @ParameterizedTest
    void ride(LadderColumn ladderColumn, LadderPosition beforePosition, LadderPosition expectedPosition) {

        assertThat(ladderColumn.ride(beforePosition)).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> ride() {
        return Stream.of(
                Arguments.of(Fixture.RIGHT_STEP_LADDER_COLUMN, LadderPosition.from(5), LadderPosition.from(6)),
                Arguments.of(Fixture.LEFT_STEP_LADDER_COLUMN, LadderPosition.from(5), LadderPosition.from(4)),
                Arguments.of(Fixture.NONE_STEP_LADDER_COLUMN, LadderPosition.from(5), LadderPosition.from(5))
        );
    }
}
