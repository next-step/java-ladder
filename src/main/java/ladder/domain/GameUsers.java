package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameUsers {

  private static final String DELIMITER = ",";
  private final List<GameUser> values;

  private GameUsers(String userNames) {
    this.values = Arrays.stream(userNames.split(DELIMITER))
        .map(GameUser::from)
        .collect(Collectors.toList());
  }

  public static GameUsers from(String userNames) {
    return new GameUsers(userNames);
  }

  public int getUserSize() {
    return this.values.size();
  }

  public String getUserName(int userIdx) {
    return values.get(userIdx).getName();
  }

  public int getUserIdx(GameUser gameUser) {
    return values.indexOf(gameUser);
  }

  public List<GameUser> getValues() {
    return values;
  }
}
