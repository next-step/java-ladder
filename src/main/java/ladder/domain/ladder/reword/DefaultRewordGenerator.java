package ladder.domain.ladder.reword;

import java.util.List;

public class DefaultRewordGenerator implements RewordGenerator {

  @Override
  public LadderGameRewordInfo generateReword(List<String> rawRewords) {
    return new LadderGameRewordInfo(rawRewords);
  }
}
