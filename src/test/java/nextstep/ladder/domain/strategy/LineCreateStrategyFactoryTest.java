package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.info.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.fixture.Fixture.CREATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LineCreateStrategyFactoryTest {
    @DisplayName("Ladder width가 1 초과이면 랜덤생성 전략을 반환한다")
    @Test
    public void should_return_LineCreateStrategy() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(3, 5);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, CREATE_STRATEGY);

        //act
        LineCreateStrategy lineCreateStrategy = LineCreateStrategyFactory.getStrategy(ladderInfo);

        //assert
        assertThat(lineCreateStrategy).isEqualTo(CREATE_STRATEGY);
    }

    @DisplayName("Ladder width가 1 이면 생성하지않는 전략을 반환한다")
    @Test
    public void should_return_None_LineCreateStrategy() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(1, 1);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, CREATE_STRATEGY);

        //act
        LineCreateStrategy lineCreateStrategy = LineCreateStrategyFactory.getStrategy(ladderInfo);

        //assert
        assertFalse(lineCreateStrategy.isCreatable());
    }
}