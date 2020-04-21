package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.model.Prize;

public class PrizeSheet {

  private List<Prize> prizeSheet;

  public PrizeSheet(List<String> prizes) {
    prizeSheet = prizes.stream()
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  public List<Prize> getPrizeSheet() {
    return prizeSheet;
  }

  public int getSize() {
    return prizeSheet.size();
  }

  public Prize get(int position) {
    return prizeSheet.get(position);
  }

}
