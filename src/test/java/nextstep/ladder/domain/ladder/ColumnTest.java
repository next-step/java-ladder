package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.ALWAYS_GENERATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 행에서 기둥을 담당하는 컬럼 클래스 테스트")
class ColumnTest {

    @DisplayName("기본적으로 컬럼은 발판 생성 전략을 가지고 초기화를 한다.")
    @Test
    void init() {
        assertThat(Column.init(ALWAYS_GENERATE_STRATEGY)).isInstanceOf(Column.class);
    }

    @DisplayName("하나의 열에는 오른쪽 발판이 있거나 없다.")
    @MethodSource
    @ParameterizedTest
    void hasRightStep(StepGenerateStrategy stepGenerateStrategy, boolean expectedValue) {
        Column column = Column.init(stepGenerateStrategy);
        assertThat(column.hasRightStep()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> hasRightStep() {
        return Stream.of(
                Arguments.of(ALWAYS_GENERATE_STRATEGY, true),
                Arguments.of(ALWAYS_GENERATE_STRATEGY, false)
        );
    }

    @DisplayName("첫번 째 컬럼은 오른쪽 발판을 가지거나 발판을 가지지 않는다.")
    void initFirstColumn() {
        Column column = Column.init(ALWAYS_GENERATE_STRATEGY);
        assertThat(column.hasRightStep()).isEqualTo(true);
    }

    @DisplayName("두번째 부터 마지막 전 컬럼 까지는 이전 컬럼의 스텝 종류에 영향을 받아 생성한다.")
    void initMiddleColumn() {

    }

    @DisplayName("마지막 컬럼 이전 컬럼의 스텝 종류에 영향을 받아 생성한다.")
    void initLastColumn() {

    }
}
