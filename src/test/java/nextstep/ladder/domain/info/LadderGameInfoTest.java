package nextstep.ladder.domain.info;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameInfoTest {

    @DisplayName("PlayerNames와 LadderInfo로 LadderGameInfo객체를 생성")
    @Test
    public void make_LadderGameInfo_using_playernames_and_ladderinfo() throws Exception {
        //arrange
        List<String> playerNames = Arrays.asList("aa","bbb");
        LadderInfo ladderInfo = LadderInfo.of(LadderSize.of(1, 1));

        //act
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(playerNames, ladderInfo);

        //assert
        assertThat(ladderGameInfo).isInstanceOf(LadderGameInfo.class);
    }

    @DisplayName("PlayerNames와 LadderHeight로 LadderGameInfo객체를 생성")
    @Test
    public void make_LadderGameInfo_using_playernames_and_ladderheight() throws Exception {
        //arrange
        List<String> playerNames = Arrays.asList("aa","bbb");
        int ladderHeight = 1;

        //act
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(playerNames, ladderHeight);

        //assert
        assertThat(ladderGameInfo).isInstanceOf(LadderGameInfo.class);
    }

    @DisplayName("Players가 null이면 LadderGameInfo를 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_players_null() throws Exception {
        //arrange
        List<String> playerNames = null;
        LadderInfo ladderInfo = LadderInfo.of(LadderSize.of(1, 1));

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameInfo.of(playerNames, ladderInfo));
    }

    @DisplayName("LadderInfo가 nul이면 LadderGameInfo를 만들 수 없고 IllegalArgumentException을 던진다")
    @Test
    public void throw_exception_when_ladderinfo_null() throws Exception {
        //arrange
        List<String> playerNames = Arrays.asList("aa","bbb");
        LadderInfo ladderInfo = null;

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameInfo.of(playerNames, ladderInfo));
    }
}