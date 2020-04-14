package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PrizeSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeSheetTest {

  @DisplayName("Test for checkPrize method")
  @Test
  public void testCheckPrize() {
    List<String> prizes = Arrays.asList("3000", "5000", "꽝", "7000");
    PrizeSheet prizeSheet = new PrizeSheet(prizes);

    IntStream.range(0, prizes.size())
        .forEach(position -> {
          Player aya = new Player("aya", position);
          assertThat(prizeSheet.checkPrize(aya).getPrize()
              .equals(prizes.get(position))).isTrue();
        });
  }
}
