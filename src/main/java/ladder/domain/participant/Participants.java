package ladder.domain.participant;

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


  public int indexOf(Name name) {
    return participants.indexOf(new Participant(name));
  }

  public int indexOf(Participant participant) {
    return participants.indexOf(participant);
  }

  public boolean containsName(Name name) {
    return participants.contains(new Participant(name));
  }
}
