package domain;

import java.util.Map;

public class Ladder {

  private Participants participants;
  private Results results;

  private Lines lines;

  public Ladder(Participants participants, Results results) {

    this.participants = participants;
    this.results = results;
  }

  public void create(int maximumLadderHeight) {

    if (maximumLadderHeight <= 0) {
      throw new IllegalArgumentException();
    }
    this.lines = new Lines(participants.number(), maximumLadderHeight);
  }

  public Participants getParticipants() {
    return participants;
  }

  public Results getResults() {
    return results;
  }

  public int height() {
    return lines.size();
  }

  public Lines getLines() {
    return lines;
  }

  public Result result(Participant participant) {

    int participantPosition = participants.position(participant);
    int resultPosition = lines.move(participantPosition);

    return results.position(resultPosition);
  }

  public Map<Participant, Result> resultsByParticipant(Participants participants) {

    return participants.allMove(results, lines);
  }
}
