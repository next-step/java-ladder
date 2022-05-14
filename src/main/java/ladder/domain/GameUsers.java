package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameUsers {

  private static final String DELIMITER = ",";
  private final List<GameUser> value;

  private GameUsers(String userNames) {
    this.value = Arrays.stream(userNames.split(DELIMITER))
        .map(GameUser::from)
        .collect(Collectors.toList());
  }

  public static GameUsers from(String userNames) {
    return new GameUsers(userNames);
  }

  public int getUserSize() {
    return this.value.size();
  }

  public String getUserName(int userIdx) {
    return value.get(userIdx).getName();
  }
}
