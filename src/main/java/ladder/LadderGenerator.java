package ladder;

import ladder.impl.DefaultLadder;

public interface LadderGenerator {
  DefaultLadder generate(int countOfPlayer, int ladderHeight);
}
