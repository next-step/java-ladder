package ladder.domain;

import java.util.List;

public class LadderGame {

  private Users users;
  private Lines lines;

  public LadderGame(int height, List<String> userNames) {
      this(new Lines(height, userNames.size()), new Users(userNames));
  }

  public LadderGame(Lines lines, Users users) {
    this.lines = lines;
    this.users = users;
  }

  public Lines getLines() {
    return lines;
  }

  public Users getUsers() {
    return users;
  }
}
