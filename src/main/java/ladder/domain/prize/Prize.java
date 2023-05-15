package ladder.domain.prize;

public class Prize {

  private final String prize;

  public Prize(String prize) {
    this.prize = prize;
  }

  public String getPrize() {
    return prize;
  }

  @Override
  public String toString() {
    return "Prize{" +
        "prize='" + prize + '\'' +
        '}';
  }
}
