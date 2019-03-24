package domain;

public class Ladder {

  private Participants participants;
  private Lines lines;

  public Ladder(Participants participants, int maximumLadderHeight) {

    this.participants = participants;

    if (maximumLadderHeight <= 0) {
      throw new IllegalArgumentException();
    }
    this.lines = new Lines(participants.number(), maximumLadderHeight);
  }

  public Participants getParticipants() {
    return participants;
  }

  public int height() {
    return lines.size();
  }

  public Lines getLines() {
    return lines;
  }
}
