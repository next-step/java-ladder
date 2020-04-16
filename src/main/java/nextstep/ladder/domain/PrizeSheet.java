package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.Prize;

public class PrizeSheet {
  private List<Prize> prizeSheet;

  public PrizeSheet(List<String> prizes) {
    prizeSheet = prizes.stream()
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  public Prize get(int position) {
    return prizeSheet.get(position);
  }
}
