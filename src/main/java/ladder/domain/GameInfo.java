package ladder.domain;

public class GameInfo {

  private final Users users;
  private final Prizes prizes;
  private static final String INVALID_GAME_INFO = "유저 수와 입력한 결과는 같은 개수여야 합니다.";

  public GameInfo(String[] userName, String[] prizes) {
    this(new Users(userName), new Prizes(prizes));
    validateUserAndPrize();
  }

  public GameInfo(Users users, Prizes prizes) {
    this.users = users;
    this.prizes = prizes;
  }

  private void validateUserAndPrize() {
    if (users.numberOfUsers() != prizes.numberOfPrizes()) {
      throw new IllegalArgumentException(INVALID_GAME_INFO);
    }
  }

  public Users getUsers() {
    return users;
  }

  public int numberOfUsers() {
    return users.numberOfUsers();
  }

  public User findUserByIndex(int index) {
    return users.findPlayerByIndex(index);
  }

  public Prize findPrizeByPosition(int finalPosition) {
    return prizes.find(finalPosition);
  }

  public Prizes getPrizes() {
    return prizes;
  }
}
