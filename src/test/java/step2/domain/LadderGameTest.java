package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.PlayersRewardsDto;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("게임 통합테스트를 진행한다.")
    void createLadder() {
        //given
        Players players = Players.of(NameSplitter.splitParticipationNames("a,b"));
        Rewards rewards = Rewards.of(NameSplitter.splitParticipationNames("1,2"));
        int ladderHeight = 10;
        PlayersRewardsDto playersRewardsDto = new PlayersRewardsDto(players, rewards);
        /*LadderDto ladderDto = new LadderDto(ladderHeight, new MustLineStrategy());
        //when
        Ladder ladder = Ladder.of(playersRewardsDto, ladderDto);
        LadderGameResult ladderGameResult = LadderGame.runGame(ladder, playersRewardsDto);

        //then
        Map<String, String> expected = new HashMap<>();
        expected.put("a", "1");
        expected.put("b", "2");

        assertThat(ladderGameResult.getResult()).isEqualTo(expected);
*/
    }
}