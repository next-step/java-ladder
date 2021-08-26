package ladderGame.step4.service;

import ladderGame.step4.model.MatchResult;

public interface Conditional {
  boolean isMatchNameCondition(MatchResult matchResult);
}