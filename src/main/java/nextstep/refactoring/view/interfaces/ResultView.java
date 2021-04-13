package nextstep.refactoring.view.interfaces;

import nextstep.ladder.domain.player.Players;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.laddergame.concrete.Rewards;
import nextstep.refactoring.laddergame.engine.LadderGameResults;

public interface ResultView {

    void printPlayers(Dto<Players> playersDto);
    void printRewards(Dto<Rewards> playersDto);
    void printLadder(Dto<Ladder> ladderDto);
    void printLadderGameResults(Dto<LadderGameResults> ladderGameResultsDto);

}
