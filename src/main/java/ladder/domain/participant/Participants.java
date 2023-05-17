package ladder.domain.participant;

import java.util.List;

public class Participants {

  private final List<Name> names;


  public Participants(List<Name> names) {
    this.names = names;
  }

  public List<Name> getParticipants() {
    return names;
  }

  public int size() {
    return names.size();
  }


  public int indexOf(Name name) {
    return names.indexOf(name);
  }

  public boolean containsName(Name name) {
    return names.contains(name);
  }
}
