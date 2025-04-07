package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
  private final List<Person> players;

  private Players(List<Person> players) {
    this.players = players;
  }

  public static Players from(String names) {
    List<Person> players =
        Arrays.stream(names.split(","))
            .map(String::trim)
            .map(Person::new)
            .collect(Collectors.toList());
    return new Players(players);
  }

  public Person get(int position) {
    return players.get(position);
  }

  public int size() {
    return players.size();
  }

  public List<String> getNames() {
    return players.stream().map(Person::getName).collect(Collectors.toList());
  }
}
