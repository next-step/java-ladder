package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.model.Prize;

public class PrizeSheet {
  private static final String PRIZE_FORMAT = "%6s";

  private List<Prize> prizeSheet;

  public PrizeSheet(List<String> prizes) {
    prizeSheet = prizes.stream()
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  public int getSize() {
    return prizeSheet.size();
  }

  public Prize get(int position) {
    return prizeSheet.get(position);
  }

  public void print() {
    prizeSheet.forEach(prize -> System.out.printf(PRIZE_FORMAT, prize.getPrize()));
    System.out.println();
  }
}
