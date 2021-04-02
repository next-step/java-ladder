package ladder.domain;

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

  public void play() {
    PrizeResult prizeResult = new PrizeResult();
    for (User user : users.getUsers()) {
      user = lines.result(user);
      prizeResult.put(user,prizes.getPrizes().get(user.getPoisition()));
    }

  }
}
