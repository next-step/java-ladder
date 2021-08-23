package ladderGame.step4.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import ladderGame.step4.service.Conditional;

public class MatchResults {

  private static final String MSG_ERROR_NO_MATCH_NAME = "검색대상자가 게임에 없습니다.";

  private static final String MSG_ERROR_NOT_INPUT_NAME = "결과 대상자를 입력 해주세요.";

  private static final String CONDITION_ALL = "all";

  private final List<MatchResult> matchResults;

  public MatchResults(final List<MatchResult> matchResults) {
    this.matchResults = Collections.unmodifiableList(matchResults);
  }

  public static MatchResults createMatchResult(Ladder ladder, Players players) {
    return new MatchResults(players.playersName()
        .stream()
        .map(playerName -> MatchResult.createMatchResult(playerName,
            ladder.findResult(players.findIndexByName(playerName))))
        .collect(Collectors.toList()));
  }

  public List<MatchResult> searchPrizeWithCondition(String findName) {
    validationEmptyName(findName);

    if (CONDITION_ALL.equals(findName)) {
      return matchPrizes(matchResult -> true);
    }

    validationNoMatchName(matchResults, findName);
    return matchPrizes(matchResult -> matchResult.isMatchName(findName));
  }

  private List<MatchResult> matchPrizes(final Conditional conditional) {
    return matchResults.stream()
        .filter(conditional::isMatchNameCondition)
        .collect(Collectors.toList());
  }

  private void validationEmptyName(final String playerName) {
    if (playerName == null || playerName.isEmpty()) {
      throw new IllegalArgumentException(MSG_ERROR_NOT_INPUT_NAME);
    }
  }

  private void validationNoMatchName(final List<MatchResult> players,
      final String playerName) {
    players.stream()
        .filter(matchResult -> matchResult.isMatchName(playerName))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(MSG_ERROR_NO_MATCH_NAME));
  }
}