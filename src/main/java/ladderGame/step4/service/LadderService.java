package ladderGame.step4.service;

import java.util.List;
import ladderGame.step4.dto.CreatorDto;
import ladderGame.step4.dto.ModelDto;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.MatchResults;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;

public class LadderService {

  public ModelDto create(final CreatorDto creatorDto) {
    Players players = Players.from(creatorDto.getPlayerNames());
    Ladder ladder = Ladder.of(creatorDto.getLadderHeight(), players.count());
    Prizes prizes = Prizes.of(creatorDto.getGoods(), players.count());

    return new ModelDto(players, ladder, prizes);
  }

  public List<MatchResult> getMatchResults(final Ladder ladder, final Players players, final String findName) {
    return MatchResults.createMatchResult(ladder, players).searchPrizeWithCondition(findName);
  }
}