package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private final List<Participant> participants;


  public Participants(List<Name> names) {
    this.participants = toParticipants(names);
  }

  private List<Participant> toParticipants(List<Name> names) {
    return names.stream()
        .map(Participant::new)
        .collect(Collectors.toList());
  }

  public List<Participant> getParticipants() {
    return participants;
  }

  public int size() {
    return participants.size();
  }



}
