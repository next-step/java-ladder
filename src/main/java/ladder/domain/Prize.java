package ladder.domain;

public class Prize {

  private final String prize;

  public Prize(String prize) {
    this.prize = prize;
  }

  @Override
  public String toString() {
    return "Prize{" +
        "prize='" + prize + '\'' +
        '}';
  }

  public String getPrize() {
    return prize;
  }
}
