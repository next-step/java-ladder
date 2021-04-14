package nextstep.refactoring.view.interfaces;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.laddergame.engine.LadderGameResultsDto;
import nextstep.refactoring.laddergame.engine.player.PlayersDto;
import nextstep.refactoring.laddergame.engine.reward.RewardsDto;

public interface ResultView {

    void printPlayers(PlayersDto playersDto);
    void printRewards(RewardsDto playersDto);
    void printLadder(LadderDto ladderDto);
    void printLadderGameResults(LadderGameResultsDto ladderGameResultsDto);

}
