package ladder.domain.store;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Name;

public class NameStore extends StringStore {

  private static final int MIN_PLAYER = 2;

  public static List<Name> createPlayers(String inputNames) {
    validateInputText(inputNames);

    List<String> players = stringToList(inputNames);
    validateMinPlayers(players);

    return players.stream()
        .map(Name::new)
        .collect(Collectors.toList());
  }

  private static void validateMinPlayers(List<String> players) {
    if (players.size() < MIN_PLAYER) {
      throw new IllegalArgumentException("참가자는 최소 " + MIN_PLAYER + "명 이상이어야 합니다.");
    }
  }
}
