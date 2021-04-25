package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Award {
  private final List<Name> prizes;

  public Award(List<Name> prizes, int expectedSize) {
    hasEqualSize(prizes, expectedSize);
    this.prizes = prizes;
  }

  private void hasEqualSize(List<Name> prizes, int memberSize) {
    if(prizes.size() != memberSize) {
      throw new IllegalArgumentException("ERROR : 당첨 목록의 개수는 생성된 멤버의 인원 수와 같아야합니다.");
    }
  }

  public static Award createPrizes(String[] prizeNames, int memberSize) {
    return new Award(Arrays.stream(prizeNames)
        .map(Name::new)
        .collect(Collectors.toList()), memberSize);
  }

  public Stream<String> prizes() {
    return prizes.stream()
        .map(Name::name);
  }

  public Name prize(int index) {
    return this.prizes.get(index);
  }

  public Award prizes(List<Integer> memberSize) {
    List<Name> collect = memberSize.stream()
        .map(prizes::get)
        .collect(Collectors.toList());

    return new Award(collect, collect.size());
  }

  public int size() {
    return prizes.size();
  }
}
