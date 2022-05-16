package ladder.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface LadderConnectStrategy {

  List<Boolean> create(int height);
}
