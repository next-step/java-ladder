package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
  private final List<Person> participants;

  public Participants(List<String> names) {
    this.participants = names.stream()
        .map(Person::new)
        .collect(Collectors.toList());
  }

  public int size() {
    return participants.size();
  }

  public List<String> getNames() {
    return participants.stream()
        .map(Person::getName)
        .collect(Collectors.toList());
  }

  public String getNameAt(int index) {
    return participants.get(index).getName();
  }
}