package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

  private static final int MIN_PARTICIPANTS_SIZE = 2;
  private static final String NAME_DELIMITER = ",";

  private final List<Name> participants;
  private final Ladder ladder;

  public LadderGame(String names, int height) {
    participants = Arrays.stream(names.split(NAME_DELIMITER))
        .map(String::trim)
        .map(Name::new)
        .collect(Collectors.toList());

    validateParticipantsSize(participants);
    ladder = new Ladder(height, participants.size());
  }

  public List<String> participants() {
    return participants.stream().map(Name::value).collect(Collectors.toList());
  }

  public Line ladderLineIndexOf(int index) {
    return ladder.lines().get(index);
  }

  public int ladderHeight() {
    return ladder.height();
  }

  public int ladderWidth() {
    return ladder.width();
  }

  private void validateParticipantsSize(List<Name> participants) {
    if (participants.size() < MIN_PARTICIPANTS_SIZE) {
      throw new IllegalArgumentException("사다리게임의 최소 참여인원은 " + MIN_PARTICIPANTS_SIZE + "명입니다.");
    }
  }
}
