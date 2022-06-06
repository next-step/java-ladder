package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {

  private static final String MESSAGE_FOR_INVALID_PRIZES = "결과의 갯수는 참가자수와 같아야 합니다.";
  private static final String PRIZE_DELIMITER = ",";

  private final List<Prize> prizes;

  Prizes(List<Prize> prizes, int playerNumber) {
    validatePrizes(prizes, playerNumber);
    this.prizes = prizes;
  }

  public List<String> prizes() {
    return prizes.stream()
        .map(Prize::toString)
        .collect(Collectors.toUnmodifiableList());
  }

  public Prize prizeFrom(LineIndex index) {
    return prizes.get(index.value());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prizes other = (Prizes) o;
    return Objects.equals(prizes, other.prizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prizes);
  }

  private void validatePrizes(List<Prize> prizes, int playerNumber) {
    if (prizes.size() != playerNumber) {
      throw new IllegalArgumentException(MESSAGE_FOR_INVALID_PRIZES);
    }
  }

  public static Prizes of(String text, Players players) {
    return new Prizes(
        Arrays.stream(text.split(PRIZE_DELIMITER))
            .map(String::strip)
            .map(Prize::new)
            .collect(Collectors.toUnmodifiableList()),
        players.playerNumber()
    );
  }
}
