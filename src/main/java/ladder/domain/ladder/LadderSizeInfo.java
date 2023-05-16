package ladder.domain.ladder;

import ladder.domain.participant.Participants;

public class LadderSizeInfo {

  private final Height height;
  private final Participants participants;

  public LadderSizeInfo(Height height, Participants participants) {
    this.height = height;
    this.participants = participants;
  }

  public int getHeight() {
    return height.height();
  }

  public int getNumberOfParticipants() {
    return participants.size();
  }

}
