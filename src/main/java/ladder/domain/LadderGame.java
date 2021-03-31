package ladder.domain;

import java.util.List;

public class LadderGame {

  private final Users users;
  private final Lines lines;

  public LadderGame(int height, String[] userNames) {
    this(new Lines(height, userNames.length), new Users(userNames));
  }

  public LadderGame(Lines lines, Users users) {
    this.lines = lines;
    this.users = users;
  }

  public Users getUsers() {
    return users;
  }

  public Lines getLines() {
    return lines;
  }
}
