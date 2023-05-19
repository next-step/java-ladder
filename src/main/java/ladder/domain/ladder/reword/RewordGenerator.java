package ladder.domain.ladder.reword;


import java.util.List;

public interface RewordGenerator {
  LadderGameRewordInfo generateReword(List<String> rawRewords);
}
