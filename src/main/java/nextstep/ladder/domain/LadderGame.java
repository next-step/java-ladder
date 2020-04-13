package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

  private Ladder ladder;
  private PrizeSheet prizeSheet;

  public LadderGame(List<String> prizes, int height) {
    ladder = new Ladder(height, prizes.size());
    prizeSheet = new PrizeSheet(prizes);
  }

  public ResultSheet play(Players players) {
    Players playersAfterRide = ladder.ride(players);

    return prizeSheet.produceResult(playersAfterRide);
  }
}
