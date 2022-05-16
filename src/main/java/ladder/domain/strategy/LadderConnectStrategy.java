package ladder.domain.strategy;

import java.util.List;

public interface LadderConnectStrategy {

  List<Boolean> create(int height);
}
