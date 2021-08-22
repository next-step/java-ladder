package ladderGame.step4.service;

import java.util.List;
import java.util.stream.Collectors;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;


public class FindResult {

  private static final String CONDITION_ALL = "all";

  private static final String RESULT_FORM = " : ";

  private static final String MSG_ERROR_NO_MATCH_NAME = "검색대상자가 게임에 없습니다.";

  private static final String MSG_ERROR_NOT_INPUT_NAME = "결과 대상자를 입력 해주세요.";

  private final Players players;

  private final Ladder ladder;

  private final Prizes prizes;

  public FindResult(final Players players, final Ladder ladder, final Prizes prizes) {
    this.players = players;
    this.ladder = ladder;
    this.prizes = prizes;
  }

  public List<String> matchPrizes(String playerName) {
    validationEmptyName(playerName);

    if (playerName.equals(CONDITION_ALL)) {
      return matchPrizesAll(name -> true);
    }

    validationNoMatchName(playerName);

    return matchPrizesAll(name -> name.equals(playerName));
  }

  private void validationEmptyName(final String playerName) {
    if (playerName == null || playerName.isEmpty()) {
      throw new IllegalArgumentException(MSG_ERROR_NOT_INPUT_NAME);
    }
  }

  private void validationNoMatchName(final String playerName) {
    if(!players.playersName().contains(playerName)){
      throw new IllegalArgumentException(MSG_ERROR_NO_MATCH_NAME);
    }
  }

  private List<String> matchPrizesAll(Conditional conditional) {

    return players.playersName()
        .stream()
        .filter(conditional::isHasCondition)
        .map(name -> name + RESULT_FORM + prizes.prizeNames().get(findPlayerIndex(name)))
        .collect(Collectors.toList());

  }

  private int findPlayerIndex(final String playerName) {
    return ladder.findResult(players.playersName().indexOf(playerName));
  }

}
