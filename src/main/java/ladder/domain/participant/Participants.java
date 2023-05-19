package ladder.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private final List<Name> names;


  public Participants(List<Name> names) {
    this.names = names;
  }

  public Participants(String... names) {
    this(Arrays.stream(names)
        .map(Name::new)
        .collect(Collectors.toList()));
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
