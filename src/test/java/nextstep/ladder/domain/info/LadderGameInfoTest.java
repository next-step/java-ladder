package nextstep.ladder.domain.info;

import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameInfoTest {

    @DisplayName("Players와 LadderInfo로 LadderGameInfo객체를 생성")
    @Test
    public void make_LadderGameInfo_using_players_and_ladderinfo() throws Exception {
        //arrange
        Players players = Players.of(Arrays.asList("aa","bbb"));
        LadderInfo ladderInfo = new LadderInfo();

        //act
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(players, ladderInfo);

        //assert
        assertThat(ladderGameInfo).isInstanceOf(LadderGameInfo.class);
    }

    @DisplayName("Players가 null이면 LadderGameInfo를 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_players_null() throws Exception {
        //arrange
        Players players = null;
        LadderInfo ladderInfo = new LadderInfo();

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameInfo.of(players, ladderInfo));
    }

    @DisplayName("LadderInfo가 nul이면 LadderGameInfo를 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_ladderinfo_null() throws Exception {
        //arrange
        Players players = Players.of(Arrays.asList("aa","bbb"));;
        LadderInfo ladderInfo = null;

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameInfo.of(players, ladderInfo));
    }
}