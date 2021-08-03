package nextstep.ladder.domain.info;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.strategy.LineCreateStrategyFactory.getRandomLineCreateStrategy;
import static nextstep.ladder.fixture.Fixture.CREATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderInfoTest {

    @DisplayName("LadderSize로 LadderInfo객체를 생성")
    @Test
    public void make_LadderGameInfo_using_players_and_ladderinfo() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(1, 1);

        //act
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, CREATE_STRATEGY);

        //assert
        assertThat(ladderInfo).isInstanceOf(LadderInfo.class);
    }

    @DisplayName("LadderSize가 null이면 LadderInfo를 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_players_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderInfo.of(null, CREATE_STRATEGY));
    }

    @DisplayName("strategy가 null이면 LadderInfo를 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_strategy_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderInfo.of(LadderSize.of(1, 1), null));
    }

}