package ladder.domain.strategy;

import java.util.List;

public interface LineGeneratorStrategy {

  List<Boolean> generateLine(int countOfPerson);

}
