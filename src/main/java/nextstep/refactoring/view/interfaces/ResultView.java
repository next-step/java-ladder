package nextstep.refactoring.view.interfaces;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.laddergame.engine.LadderGameResultDto;
import nextstep.refactoring.laddergame.engine.player.PlayersDto;
import nextstep.refactoring.laddergame.engine.reward.RewardsDto;

import java.util.List;

public interface ResultView {

    void printPlayers(PlayersDto playersDto);
    void printRewards(RewardsDto playersDto);
    void printLadder(LadderDto ladderDto);
    void printLadderGameResults(List<LadderGameResultDto>ladderGameResultsDto);

}
