package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.TestLadder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.player.TestPlayers;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.domain.reward.TestRewards;
import nextstep.ladder.dto.LadderGameReport;
import nextstep.ladder.dto.PlayerDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameTest {

    private final Ladder ladder = TestLadder.ladder();
    private final Rewards rewards = TestRewards.rewards();
    private final LadderBoard ladderBoard = new LadderBoard(ladder, rewards);

    private final Players players = TestPlayers.players();
    private final LadderGame ladderGame = new LadderGame(players, ladderBoard);

    @Test
    @DisplayName("특정 참가자의 이름을 받으면 해당 참가자의 결과만을 리포트로 작성한다.")
    void makeResultReportOfSinglePlayer() {
        String pobi = "pobi";
        LadderGameReport report = ladderGame.makeResultReport(pobi);
        List<PlayerDto> playerDtoList = report.getPlayerDtoList();

        assertAll(
            () -> assertThat(playerDtoList.size()).isEqualTo(1),
            () -> assertThat(playerDtoList.get(0).getName()).isEqualTo(pobi),
            () -> assertThat(playerDtoList.get(0).getReward()).isEqualTo("꽝")
        );
    }

    @Test
    @DisplayName("전체 참가자를 지칭하는 'all' 을 요청으로 받을 경우 전체 참가자의 리포트를 작성한다.")
    void makeResultReportOfAllPlayers() {
        String all = "all";
        LadderGameReport report = ladderGame.makeResultReport(all);

        List<String> expectedPlayerNames = Arrays.asList("pobi", "honux", "crong", "jk");
        List<String> expectedRewards = Arrays.asList("꽝", "3000", "꽝", "5000");

        List<String> names = report.getPlayerDtoList().stream()
                                   .map(PlayerDto::getName)
                                   .collect(Collectors.toList());
        List<String> rewards = report.getPlayerDtoList().stream()
                                     .map(PlayerDto::getReward)
                                     .collect(Collectors.toList());

        assertAll(
            () -> assertThat(names).containsExactlyElementsOf(expectedPlayerNames),
            () -> assertThat(rewards).containsExactlyElementsOf(expectedRewards)
        );
    }

    @Test
    @DisplayName("결과를 알고 싶은 참가자가 실제로 없는 경우 예외 처리한다.")
    void throwExceptionWhenPlayerNotExistThatHasName() {
        assertThatThrownBy(() -> ladderGame.makeResultReport("tdd")).isInstanceOf(RuntimeException.class);
    }

}
