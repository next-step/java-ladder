package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

  private final List<String> participants;
  private final Ladder ladder;

  public LadderGame(String names, int height) {
    participants = Arrays.stream(names.split(","))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .collect(Collectors.toList());

    validateSplitNames(participants);
    ladder = new Ladder(height, participants.size());
  }

  public List<String> participants() {
    return participants;
  }

  public Ladder ladder() {
    return ladder;
  }

  private void validateSplitNames(List<String> splitNames) {
    if (splitNames.size() < 2) {
      throw new IllegalArgumentException("사다리게임의 최소 참여인원은 2명입니다.");
    }
  }
}
