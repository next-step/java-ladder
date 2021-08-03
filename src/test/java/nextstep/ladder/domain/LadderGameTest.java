package nextstep.ladder.domain;

import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.info.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.fixture.Fixture.CREATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    @DisplayName("LadderSize로 LadderInfo객체를 생성")
    @Test
    public void make_LadderGame_using_ladderinfo() throws Exception {
        //arrange
        List<String> playerNames = Arrays.asList("a", "bb", "ccc");
        LadderInfo ladderInfo = LadderInfo.of(LadderSize.of(1, 1), CREATE_STRATEGY);
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(playerNames, ladderInfo);

        //act
        LadderGame ladderGame = LadderGame.of(ladderGameInfo);

        //assert
        assertThat(ladderGame).isInstanceOf(LadderGame.class);
    }

    @DisplayName("LadderSize가 null이면 LadderGame을 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_ladderGameInfo_null() throws Exception {
        //arrange
        LadderGameInfo ladderGameInfo = null;

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGame.of(ladderGameInfo));
    }

}
