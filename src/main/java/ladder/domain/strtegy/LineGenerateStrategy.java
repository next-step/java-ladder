package ladder.domain.strtegy;

import ladder.domain.LadderLine;

@FunctionalInterface
public interface LineGenerateStrategy {
  LadderLine generate(int size);
}
