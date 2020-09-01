package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public List<String> nameToList() {
    return prizes.stream()
            .map(Prize::getName)
            .collect(Collectors.toList());
  }

  public Prize prizeOf(Chessmen chessmen) {
    if (chessmen.getLocation() > prizes.size()) {
      throw new IllegalArgumentException("말의 위치가 잘 못 되었습니다.");
    }
    return prizes.get(chessmen.getLocation());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Prizes prizes1 = (Prizes) o;
    return Objects.equals(prizes, prizes1.prizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prizes);
  }

  @Override
  public String toString() {
    return "Prizes{" +
            "prizes=" + prizes +
            '}';
  }
}
