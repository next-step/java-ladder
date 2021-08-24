package ladderGame.step4.service;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.MatchResults;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;

public class LadderService {

  private Players players;

  private Ladder ladder;

  public List<String> createPlayers(final String playerNames) {
    players = new Players(Players.from(playerNames));
    return players.playersName();
  }

  public Ladder createLadder(final int ladderHeight) {
    validationPlayers();
    ladder =  new Ladder(Ladder.of(ladderHeight, players.count()));
    return ladder;
  }

  private void validationPlayers() {
    if(players == null){
      throw new IllegalArgumentException("사용자를 먼저 등록해주세요.");
    }
  }

  public Prizes createPrizes(final String goods) {
    validationPlayers();
    return new Prizes(Prizes.of(goods, players.count()));
  }

  public List<MatchResult> getMatchResults(final String findName) {
    validationPlayers();
    validationLadder();
    return MatchResults.createMatchResult(ladder, players).searchPrizeWithCondition(findName);
  }

  private void validationLadder() {
    if(ladder == null){
      throw new IllegalArgumentException("사다리를 먼저 생성해주세요.");
    }
  }
}