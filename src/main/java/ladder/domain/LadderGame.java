package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

  private final Users users;
  private final Lines lines;
  private final Prizes prizes;
  private static final String INVALID_HEIGHT = "높이는 양수여야합니다.";

  public LadderGame(int height, String[] userNames,String[] prizes) {
    this(new Lines(height, userNames.length), new Users(userNames),new Prizes(prizes));
    validateHeight(height);
  }

  public LadderGame(Lines lines, Users users,Prizes prizes) {
    this.lines = lines;
    this.users = users;
    this.prizes = prizes;
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

  public PrizeResult play() {

    PrizeResult prizeResult = new PrizeResult();
    int numberOfUsers = users.numberOfUsers();

    for (int index = 0; index < numberOfUsers; index++) {
      User user = users.findPlayerByIndex(index);
      int finalPosition = lines.goThroughLinesFrom(index);
      Prize prize = prizes.getPrizes().get(finalPosition);
      prizeResult.put(user,prize);
    }
    return prizeResult;
  }

  public Prizes getPrizes() {
    return prizes;
  }
}
