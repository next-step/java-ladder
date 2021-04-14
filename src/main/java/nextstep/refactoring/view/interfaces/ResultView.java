package nextstep.refactoring.view.interfaces;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.laddergame.engine.player.PlayersDto;

public interface ResultView {

    void printPlayers(PlayersDto playersDto);
//    void printRewards(Dto<Rewards> playersDto);
    void printLadder(LadderDto ladderDto);
//    void printLadderGameResults(LadderGameResultsDto ladderGameResultsDto);

}
