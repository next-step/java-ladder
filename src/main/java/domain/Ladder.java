package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

  private List<Participant> participants;
  private List<Line> lines;

  public Ladder(List<Participant> participants, int height) {

    if (height <= 0) {
      throw new IllegalArgumentException();
    }

    if (participants == null || participants.isEmpty() || participants.size() == 1) {
      throw new IllegalArgumentException();
    }
    this.participants = participants;

    this.lines = IntStream.range(0, height)
        .mapToObj(index -> new Line(participants.size()))
        .collect(Collectors.toList());
  }

  public List<Line> getLines() {
    return lines;
  }

  public String getParticipantNames() {

    return participants.stream()
        .map(participant -> String.format("%5s", participant.getName()))
        .collect(Collectors.joining(" "));
  }
}
