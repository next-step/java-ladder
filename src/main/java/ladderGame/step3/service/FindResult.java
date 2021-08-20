package ladderGame.step3.service;

import java.util.List;
import java.util.stream.Collectors;
import ladderGame.step3.model.Ladder;
import ladderGame.step3.model.Players;
import ladderGame.step3.model.Prizes;


public class FindResult {

  private static final String CONDITION_ALL = "all";

  private static final String RESULT_FORM = " : ";

  private static final String MSG_ERROR_NO_MATCH_NAME = "검색대상자가 게임에 없습니다.";

  private final Players players;

  private final Ladder ladder;

  private final Prizes prizes;

  public FindResult(final Players players, final Ladder ladder, final Prizes prizes) {
    this.players = players;
    this.ladder = ladder;
    this.prizes = prizes;
  }

  public List<String> matchPrizes(String playerName) {
    if (playerName == null || playerName.isEmpty()) {
      throw new IllegalArgumentException("결과 대상자를 입력 해주세요.");
    }

    if (playerName.equals(CONDITION_ALL)) {
      return matchPrizesAll(name -> true);
    }

    return matchPrizesByCondition(name -> name.equals(playerName));
  }

  private List<String> matchPrizesAll(Conditional conditional) {

    validationMatchNames(conditional);

    return players.playersName()
        .stream()
        .filter(conditional::isHasCondition)
        .map(name -> name + RESULT_FORM + prizes.prizeNames().get(findPlayerIndex(name)))
        .collect(Collectors.toList());

  }

  private void validationMatchNames(final Conditional conditional) {
    players.playersName()
        .stream()
        .filter(conditional::isHasCondition)
        .map(name -> name + RESULT_FORM + prizes.prizeNames().get(findPlayerIndex(name)))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(MSG_ERROR_NO_MATCH_NAME));
  }

  private List<String> matchPrizesByCondition(Conditional conditional) {
    return matchPrizesAll(conditional);
  }

  private int findPlayerIndex(final String playerName) {
    return ladder.findResult(players.playersName().indexOf(playerName));
  }

}
