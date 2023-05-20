package ladder.domain.ladder.reword;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import utils.StringUtils;

public class LadderGameRewordInfo {
  private static final String ZERO_VALUE_ALIAS = "꽝";
  private static final Map<Integer, LadderGameReword> rewordCache = new HashMap<>();

  private final List<LadderGameReword> rewords;

  public LadderGameRewordInfo(List<String> rawRewords) {
    this.rewords = rawRewords.stream()
        .map(this::createReword)
        .collect(Collectors.toUnmodifiableList());
  }

  public LadderGameReword getRewordAt(int lineIndex) {
    return rewords.get(lineIndex);
  }

  private LadderGameReword createReword(String rawReword) {
    int prize = getRewordPrizeFromRawReword(rawReword);
    LadderGameReword ladderGameReword = rewordCache.get(prize);
    if (ladderGameReword != null) {
      return ladderGameReword;
    }

    LadderGameReword newReword = new LadderGameReword(prize);
    rewordCache.putIfAbsent(prize, newReword);

    return newReword;
  }

  private int getRewordPrizeFromRawReword(String rawReword) {
    if(ZERO_VALUE_ALIAS.equals(rawReword)) {
      return 0;
    }

    if (StringUtils.isDigit(rawReword)) {
      return Integer.parseInt(rawReword);
    }

    throw new LadderGameException(ExceptionCode.REWORD_IS_NOT_NUMERIC);
  }
}
