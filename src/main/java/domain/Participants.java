package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private List<Participant> participants;

  public Participants(List<Participant> participants) {

    if (participants == null || participants.isEmpty() || participants.size() == 1) {
      throw new IllegalArgumentException();
    }
    this.participants = participants;
  }

  public int number() {
    return participants.size();
  }

  public String names() {

    return participants.stream()
        .map(participant -> String.format("%5s", participant.getName()))
        .collect(Collectors.joining(" "));
  }
}
