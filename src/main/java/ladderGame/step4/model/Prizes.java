package ladderGame.step4.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {

  private static final String SPLIT_MARK = ",";

  private static final String MSG_ERROR_INPUT_PRIZES = "상품을 입력해주세요.";

  public static final String MSG_ERROR_INCORRECT_COUNT = "상품 등록 개수를 참가자 수와 맞춰 주세요.";

  private final List<PrizeName> prizes;

  public Prizes(final List<PrizeName> prizes) {
    this.prizes = Collections.unmodifiableList(prizes);
  }

  public static List<PrizeName> createPrizes(String goods, int playerCount){
    validationPrizeCount(goods, playerCount);

    return splitPrizeName(goods)
        .stream()
        .map(PrizeName::new)
        .collect(Collectors.toList());
  }

  public List<String> prizeNames(){
    return prizes.stream()
        .map(PrizeName::prizeName)
        .collect(Collectors.toList());
  }

  private static void validationPrizeCount(final String goods, final int playerCount) {
    if(splitPrizeName(goods).size() != playerCount){
      throw new IllegalArgumentException(MSG_ERROR_INCORRECT_COUNT);
    }
  }

  private static List<String> splitPrizeName(final String goods) {
    validationGoods(goods);

    return Arrays.asList(goods.split(SPLIT_MARK));
  }

  private static void validationGoods(final String goods) {
    if(goods == null || goods.isEmpty()){
      throw new IllegalArgumentException(MSG_ERROR_INPUT_PRIZES);
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Prizes prizes1 = (Prizes) o;
    return Objects.equals(prizes, prizes1.prizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prizes);
  }
}
