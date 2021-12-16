package nextstep.ladder.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PrizeGroup {

  private static final String COMMA = ",";
  private static final String NOT_VALID_COUNT = "참여인원과 결과의 수가 같아야합니다.";

  private final List<Prize> prizeList;

  public PrizeGroup(String strings, Names names) {
   this(validCount(strings, names));
  }

  public PrizeGroup(String strings) {
    this(getSplitNameByDelimiter(strings));
  }

  public PrizeGroup(List<Prize> prizeList) {
    this.prizeList = prizeList;
  }

  private static List<Prize> getSplitNameByDelimiter(String name) {
    return Arrays.stream(name.split(COMMA))
                 .map(String::trim)
                 .map(Prize::new)
                 .collect(toList());
  }

  private static List<Prize> validCount(String strings, Names names) {
    List<Prize> splitNameByDelimiter = getSplitNameByDelimiter(strings);

    if (names.size() != splitNameByDelimiter.size()) {
      throw new IllegalArgumentException(NOT_VALID_COUNT);
    }

    return splitNameByDelimiter;
  }

  public Prize getResult(int index) {
    return prizeList.get(index);
  }

  public Stream<Prize> stream() {
    return prizeList.stream();
  }

}
