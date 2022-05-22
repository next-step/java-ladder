package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameUsers {

  private static final String DELIMITER = ",";
  private final List<GameUser> values;

  private GameUsers(String userNames) {
    List<GameUser> gameUsers = Arrays.stream(userNames.split(DELIMITER))
        .map(GameUser::from)
        .collect(Collectors.toList());
    this.values = Collections.unmodifiableList(gameUsers);
  }

  public static GameUsers from(String userNames) {
    return new GameUsers(userNames);
  }

  public int getUserSize() {
    return this.values.size();
  }

  public int getUserPoint(GameUser gameUser) {
    return values.indexOf(gameUser);
  }

  public List<GameUser> getValues() {
    return values;
  }
}
