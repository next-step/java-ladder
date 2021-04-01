package ladder.domain;

import java.util.List;

public class LadderGame {

  private final Users users;
  private final Lines lines;
  private final String INVALID_HEIGHT = "높이는 양수여야합니다.";

  public LadderGame(int height, String[] userNames) {
    this(new Lines(height, userNames.length), new Users(userNames));
    validateHeight(height);
  }

  public LadderGame(Lines lines, Users users) {
    this.lines = lines;
    this.users = users;
  }

  private void validateHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException(INVALID_HEIGHT);
    }
  }

  public Users getUsers() {
    return users;
  }

  public Lines getLines() {
    return lines;
  }
}
